package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.student.Student;

import java.util.List;
import java.util.Set;

public class CourseForm {

    private Integer courseId;

    private String title;

    private String description;

    private Set<Student> students;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
