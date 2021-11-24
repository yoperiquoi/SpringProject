package fr.imta.fil.markentry.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

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
     * Setter of isNew
     * @param aNew - New boolean value of isNew
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
