package models;

import java.util.*;
import javax.persistence.*;

/**
 * Created by scarneiro on 11/26/2016.
 */
@Entity
@DiscriminatorValue(value="student")
public class Student extends User {

    @ManyToMany(mappedBy="studentsEnrolled")
    private List<Class> classes;

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

}
