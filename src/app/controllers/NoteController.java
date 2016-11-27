package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Transaction;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

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

        Student u = ebeanServer.find (Student.class).where().idEq(1).findUnique();

        return ok(views.html.index.render(u.getCreated().toString()));
    }

}
            
