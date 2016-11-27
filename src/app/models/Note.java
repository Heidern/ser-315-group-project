package models;

import org.hibernate.validator.constraints.Length;
import play.data.validation.Constraints;

import javax.persistence.*;

/**
 * Created by scarneiro on 11/27/2016.
 */
@Entity
public class Note {

    @Id
    private long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    @JoinColumn (name = "class_id")
    private Class studentClass;

    @Constraints.MaxLength(255)
    private String title;

    private String contents;

    public long getId() {
        return id;
    }

    public Student getOwner() {
        return student;
    }

    public String getTitle () {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Class getStudentClass () {
        return studentClass;
    }

    public void setOwner(Student student) {
        this.student = student;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setStudentClass (Class studentClass) {
        this.studentClass = studentClass;
    }

}
