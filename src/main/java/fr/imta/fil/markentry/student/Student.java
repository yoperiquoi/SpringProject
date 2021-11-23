package fr.imta.fil.markentry.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;


@Table("student")
public class Student implements Persistable<Integer> {


    @Id
    private int studentId;

    private String firstname;

    private String lastname;

    @Transient
    private boolean isNew = false;

    @Override
    public Integer getId() {
        return studentId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setStudentId(int studentId) {
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

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
