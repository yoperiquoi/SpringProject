package fr.imta.fil.markentry.model;

import fr.imta.fil.markentry.model.Student;
import java.util.Set;

/**
 * This class allows to cast the course in a course for a response
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
public class CourseResponse {

    public Integer courseId;

    public String title;

    public String description;

    public Set<Student> students;

    /**
     * Empty constructor method to instantiate automatically the spring applicaiton
     */
    public CourseResponse() {}

    /**
     * Constructor method.
     * @param courseId - ID of the course
     * @param title - Title of the course
     * @param description - Main description of the course
     */
    public CourseResponse(Integer courseId, String title, String description){
        this.courseId = courseId;
        this.title = title;
        this.description = description;
    }

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
