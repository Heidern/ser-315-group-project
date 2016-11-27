package models;

import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.validation.*;

/**
 * Created by scarneiro on 11/26/2016.
 */
@Entity
public class Subject {

    @Id
    public Long id;

    @Constraints.Required
    @Constraints.MaxLength(255)
    public String name;

    @Constraints.Required
    @Constraints.MaxLength(4)
    public String abbreviation;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
