package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Transaction;
import play.Environment;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import viewmodels.NoteTitleAndId;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
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

    public Result note() {

        long classId = Long.parseLong(request().getQueryString("classId"));
        long studentId = Long.parseLong(request().getQueryString("studentId"));
        long noteId = Long.parseLong(request().getQueryString("noteId"));

        List<Note> notes = ebeanServer
                .find(Note.class)
                .select("id, title")
                .where()
                .conjunction()
                .eq("student_id", studentId)
                .eq("class_id", classId)
                .endJunction()
                .findList();

        Note currentNote = ebeanServer
                .find(Note.class)
                .where()
                .idEq(noteId)
                .findUnique();

        viewmodels.Note noteViewModel = new viewmodels.Note ();

        for (Note n : notes) {
            NoteTitleAndId titleAndId = new NoteTitleAndId();

            titleAndId.Id = n.getId();
            titleAndId.Title = n.getTitle();

            noteViewModel.NoteTitles.add (titleAndId);
        }

        noteViewModel.CurrentNoteId = currentNote.getId ();
        noteViewModel.CurrentNoteContents = currentNote.getContents();

        return ok(views.html.note.render(noteViewModel));
    }
}
            
