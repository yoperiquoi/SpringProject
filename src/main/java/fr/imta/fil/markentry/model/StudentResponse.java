package fr.imta.fil.markentry.model;

import java.util.HashMap;
import java.util.Set;

/**
 * This class allows to cast the course in a student for a response
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
public class StudentResponse {

    private Integer studentId;

    private String firstname;

    private String lastname;

    private Set<Course> courses;

    private HashMap<Integer, Integer> evaluation;

    /**
     * Empty constructor method to instantiate automatically the spring applicaiton
     */
    public StudentResponse(){}

    /**
     * Constructor method
     * @param studentId student id as a int
     * @param firstname student firstname as a String
     * @param lastname student lastname as  a String
     */
    public StudentResponse(Integer studentId, String firstname, String lastname){
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Getter of student id
     * @return a student id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Setter of student id
     * @param studentId the new student id
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter of student firstname
     * @return a student firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Setter of student firstname
     * @param firstname the new student firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Getter of student lastname
     * @return a student lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Setter of student lastname
     * @param lastname the new student lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Getter of courses
     * @return the courses list of the student
     */
    public Set<Course> getCourses() {
        return courses;
    }

    /**
     * Setter of courses
     * @param courses the new list of courses
     */
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public HashMap<Integer, Integer> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(HashMap<Integer, Integer> evaluation) {
        this.evaluation = evaluation;
    }
}
