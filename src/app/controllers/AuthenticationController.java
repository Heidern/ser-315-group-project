package controllers;

import com.avaje.ebean.EbeanServer;
import com.google.inject.Inject;
import models.Student;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import viewmodels.LoginStudent;

import java.util.List;

/**
 * Created by scarneiro on 11/27/2016.
 */
public class AuthenticationController extends Controller {

    private EbeanServer ebeanServer;
    private FormFactory formFactory;

    @Inject
    public AuthenticationController (EbeanServer ebeanServer, FormFactory formFactory) {

        this.ebeanServer = ebeanServer;
        this.formFactory = formFactory;

    }

    public Result login () {

        return ok(views.html.login.render(getStudents()));

    }

    public Result logout () {

        session().clear();

        return redirect(routes.AuthenticationController.login());

    }

    public Result loggingIn () {

        DynamicForm form = formFactory.form ().bindFromRequest();

        session().put ("userId", form.get("userId"));

        return redirect(routes.NoteController.allStudentNotes(1));
    }

    private viewmodels.Login getStudents () {
        List<Student> students = ebeanServer
                .find(Student.class)
                .select("user_id, username")
                .findList();

        viewmodels.Login loginViewModel = new viewmodels.Login ();

        for (Student s : students) {
            LoginStudent studentLoginInfo = new LoginStudent();

            studentLoginInfo.UserId = s.getId();
            studentLoginInfo.Username = s.getUsername();

            loginViewModel.Students.add (studentLoginInfo);
        }

        return loginViewModel;
    }
}
