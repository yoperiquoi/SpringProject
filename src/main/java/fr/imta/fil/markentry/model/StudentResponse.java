package fr.imta.fil.markentry.model;

import java.util.Set;

public class StudentResponse {

    private Integer studentId;

    private String firstname;

    private String lastname;

    private Set<Course> courses;

    public StudentResponse(){}

    public StudentResponse(Integer studentId, String firstname, String lastname){
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
