package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

/**
 * Created by Sadai on 11/21/2016.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class User {

    @Id
    private long id;

    private DateTime created;

    @Constraints.Required
    private String username;

    private String firstName;

    private String lastName;

    @Constraints.Email
    private String emailAddress;

    public long getId() { return id; }

    public DateTime getCreated() {
        return created;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
