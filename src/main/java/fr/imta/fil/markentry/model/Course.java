package fr.imta.fil.markentry.model;

import fr.imta.fil.markentry.model.StudentRef;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is the course table ORM (Object-Relationnal Mapping).
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 22/11/2021
 *
 */


@Table("course")
public class Course implements Persistable<Integer> {

    @Id
    private int courseId;

    private String title;

    private String description;

    @Transient
    private boolean isNew = false;


    /**
     * Empty constructor method to instantiate automatically the spring applicaiton
     */
    public Course(){}

    /**
     * Constructor method.
     * @param courseId - ID of the course
     * @param title - Title of the course
     * @param description - Main description of the course
     */
    public Course(int courseId, String title, String description) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.isNew = true;
    }

    @MappedCollection(idColumn = "course_id", keyColumn = "course_id")
    private Set<StudentRef> students = new HashSet<>();

    /**
     * Allows to add a student in the students Set of the course link to follow.
     * @param studentRef
     */
    public void addStudent(StudentRef studentRef) {
        students.add(studentRef);
    }

    /**
     * Getter of courseId
     * @return courseId as an Integer.
     */
    @Override
    public Integer getId() {
        return courseId;
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
     * Setter of courseId
     * @param courseId - ID of the course
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Getter of title
     * @return title as a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter of title
     * @param title - Title of the course
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter of description
     * @return description as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter description
     * @param description - Main description of the course
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter of isNew
     * @param aNew - New boolean value of isNew
     */
    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    /**
     * Getter of the students collection
     * @return all the student
     */
    public Set<StudentRef> getStudents() {
        return students;
    }

    /**
     * Allows to change the list of the students
     * @param students the new student list of the course
     */
    public void setStudents(Set<StudentRef> students) {
        this.students = students;
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString(){
        return courseId + " : " + title + " " + description;
    }
}
