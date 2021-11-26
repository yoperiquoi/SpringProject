package fr.imta.fil.markentry.student;

import org.springframework.data.relational.core.mapping.Table;

@Table("follow")
public class StudentRef {

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
