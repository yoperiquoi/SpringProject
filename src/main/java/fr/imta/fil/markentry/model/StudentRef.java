package fr.imta.fil.markentry.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("follow")
public class StudentRef {

    @Column("student_id")
    private Integer studentId;

    public StudentRef() {
    }

    public StudentRef(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
