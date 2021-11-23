package fr.imta.fil.markentry.course;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("course")
public class Course implements Persistable<Integer> {

    @Id
    private int courseId;

    private String title;

    private String description;

    @Transient
    private boolean isNew = false;

    public Course(){
    }

    public Course(int courseId, String title, String description) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.isNew = true;
    }

    @Override
    public Integer getId() {
        return courseId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString(){
        return courseId + " : " + title + " " + description;
    }
}
