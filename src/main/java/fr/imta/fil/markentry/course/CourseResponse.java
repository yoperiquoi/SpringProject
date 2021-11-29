package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.student.Student;

import java.util.Set;

public class CourseResponse {

    public Integer courseId;

    public String title;

    public String description;

    public Set<Student> students;

    public CourseResponse() {}

    public CourseResponse(Integer courseId, String title, String description){
        this.courseId = courseId;
        this.title = title;
        this.description = description;
    }

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
