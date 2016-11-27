package controllers;

import com.avaje.ebean.EbeanServer;
import models.Note;
import models.Student;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodels.NoteTitleAndId;

import javax.inject.Inject;
import java.util.List;

/**
 * Manage a database of computers
 */
public class NoteController extends Controller {

    private FormFactory formFactory;
    private EbeanServer ebeanServer;

    @Inject
    public NoteController(FormFactory formFactory, EbeanServer ebeanServer) {
        this.formFactory = formFactory;
        this.ebeanServer = ebeanServer;
    }

    public Result index() {

        Student u = ebeanServer
                .find (Student.class)
                .fetch("classes")
                .fetch("classes.course")
                .where().idEq(1).findUnique();

        StringBuilder sb = new StringBuilder ();

        for (models.Class c : u.getClasses()) {
            sb.append(c.toString());

            List<Note> classNotes = ebeanServer
                    .find(Note.class)
                    .where()
                    .conjunction()
                        .eq("student_id", u.getId())
                        .eq("class_id", c.getId())
                    .endJunction()
                    .findList();

            for (Note n : classNotes)
                sb.append (n.getContents());
        }

        return ok(views.html.index.render (sb.toString()));
    }

    public Result allStudentNotes (long classId) {

        long studentId = Long.parseLong(session("userId"));

        viewmodels.Note note = getNote (classId, studentId, 0);

        return ok(views.html.note.render(note));

    }

    public Result studentNote (long classId, long noteId) {

        long studentId = Long.parseLong(session("userId"));

        viewmodels.Note note = getNote (classId, studentId, noteId);

        return ok(views.html.note.render(note));

    }

    private viewmodels.Note getNote (long classId, long studentId, long noteId) {
        List<Note> notes = ebeanServer
                .find(Note.class)
                .select("id, class_id, title")
                .where()
                .conjunction()
                .eq("student_id", studentId)
                .eq("class_id", classId)
                .endJunction()
                .findList();

        viewmodels.Note noteViewModel = new viewmodels.Note ();

        for (Note n : notes) {
            NoteTitleAndId titleAndId = new NoteTitleAndId();

            titleAndId.ClassId = n.getStudentClass().getId();
            titleAndId.Id = n.getId();
            titleAndId.Title = n.getTitle();

            noteViewModel.NoteTitles.add (titleAndId);

            if (n.getId() == noteId || (noteId == 0 && noteViewModel.CurrentNoteId == 0)) {
                noteViewModel.CurrentNoteId = n.getId();
                noteViewModel.CurrentNoteTitle = n.getTitle();
                noteViewModel.CurrentNoteContents = n.getContents();
            }
        }

        return noteViewModel;
    }
}
            
