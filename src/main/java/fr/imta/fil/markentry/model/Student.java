package fr.imta.fil.markentry.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

/**
 * This class is the student table ORM (Object-Relationnal Mapping).
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 22/11/2021
 *
 */

@Table("student")
public class Student implements Persistable<Integer> {


    @Id
    private int studentId;

    private String firstname;

    private String lastname;

    @Transient
    private boolean isNew;

    @MappedCollection(idColumn = "student_id", keyColumn = "student_id")
    private Set<CourseRef> courses = new HashSet<>();

    /**
     * Allows to add a course in the course Set of the student link to follow.
     * @param courseRef
     */
    public void addCourse(CourseRef courseRef) {
        courses.add(courseRef);
    }

    /**
     * Constructor method.
     * @param studentId - ID of the student
     * @param firstname - Firstname of the student
     * @param lastname - Lastname of the student
     */
    public Student(int studentId, String firstname, String lastname) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isNew = true;
    }

    /**
     * Getter of studentId
     * @return ID as an Integer
     */
    @Override
    public Integer getId() {
        return studentId;
    }

    /**
     * Getter of isNew
     * @return isNew as an Boolean.
     */
    @Override
    public boolean isNew() {
        return isNew;
    }

    /**
     * Setter of studentId
     * @param studentId - ID of the student
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter of the firstname
     * @return firstname as a String
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Setter of firstname
     * @param firstname - Firstname of the student
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Getter of lastname
     * @return lastname as a String
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Setter of lastname
     * @param lastname - Lastname of the student
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Getter of the courses
     * @return the list of the courses
     */
    public Set<CourseRef> getCourses() {
        return this.courses;
    }

    /**
     * Setter of the courses
     * @param courses the new list of the courses
     */
    public void setCourses(Set<CourseRef> courses) {
        this.courses = courses;
    }

    /**
     * Setter of isNew
     * @param aNew the new boolean value for isNew
     */
    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return studentId + " : " + firstname + " " + lastname;
    }

}
