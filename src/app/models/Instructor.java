package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by scarneiro on 11/26/2016.
 */
@Entity
@DiscriminatorValue(value="faculty")
public class Faculty extends User {

    @ManyToMany(mappedBy="instructors")
    private List<Class> classes;

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

}
