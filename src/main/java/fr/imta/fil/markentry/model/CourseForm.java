package fr.imta.fil.markentry.model;

import fr.imta.fil.markentry.model.Student;

/**
 * This class allows to cast the request in a course
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */

import java.util.Set;

public class CourseForm {

    private Integer courseId;

    private String title;

    private String description;

    private Set<Student> students;

    /**
     * Getter of courseId
     * @return a course id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * Setter of courseId
     * @param courseId the new course id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * Getter of title
     * @return the course title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter of title
     * @param title the new course title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter of description
     * @return the course description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter of description
     * @param description the new course description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter of students
     * @return the students list of the course
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Setter of students
     * @param students the new list of student
     */
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
