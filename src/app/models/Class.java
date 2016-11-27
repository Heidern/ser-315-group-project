package models;

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
    @JoinTable(
        name="class_student",
        joinColumns = @JoinColumn (name = "class_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn (name = "student_id", referencedColumnName = "id")
    )
    private List<Student> studentsEnrolled;

    @ManyToMany
    @JoinTable(
            name="class_instructor",
            joinColumns = @JoinColumn (name = "class_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "instructor_id", referencedColumnName = "id")
    )
    private List<Instructor> instructors;

    public long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public int getNumber() {
        return number;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public String toString () {
        return course.toString () + " - " + number;
    }

}
