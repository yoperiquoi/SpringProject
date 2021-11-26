package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.course.Course;
import fr.imta.fil.markentry.course.CourseRef;
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
    private boolean isNew = false;

    @MappedCollection(idColumn = "student_id", keyColumn = "student_id")
    private Set<CourseRef> courses;

    public void addCourse(CourseRef courseRef) {
        courses.add(courseRef);
    }

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


    public Set<CourseRef> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<CourseRef> courses) {
        this.courses = courses;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
