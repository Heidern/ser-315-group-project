package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by scarneiro on 11/26/2016.
 */
@Entity
public class Class {

    @Id
    private long id;

    @ManyToOne
    private Course course;

    private int number;

    @ManyToMany
    private List<Student> studentsEnrolled;
}
