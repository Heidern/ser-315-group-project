package models;

import play.data.validation.Constraints;

import javax.persistence.*;

import java.util.List;

/**
 * Created by scarneiro on 11/26/2016.
 */
@Entity
public class Course {

    @Id
    private long id;

    @OneToOne
    @Constraints.Required
    private Subject subject;

    @Constraints.Required
    @Constraints.MaxLength(255)
    private String title;

    private int courseNumber;

    private int units;

    @Constraints.MaxLength(1024)
    private String description;

    @ManyToMany
    private List<Course> prerequisites;

    public long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public int getUnits() {
        return units;
    }

    public String getDescription() {
        return description;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String toString () {
        return subject.getAbbreviation() + " " + courseNumber + " - " + title;
    }
}
