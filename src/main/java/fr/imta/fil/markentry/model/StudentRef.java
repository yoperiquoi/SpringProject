package fr.imta.fil.markentry.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * This student class is associated to the follow table.
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */

@Table("follow")
public class StudentRef {

    @Column("student_id")
    private Integer studentId;

    /**
     * Empty constructor method to instantiate automatically the spring applicaiton
     */
    public StudentRef() {
    }

    /**
     * Constructor method
     * @param studentId the student id
     */
    public StudentRef(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter studentId
     * @return the student id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Setter studentId
     * @param studentId the new studentId
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
