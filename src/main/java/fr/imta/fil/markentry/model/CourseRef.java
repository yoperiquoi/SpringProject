package fr.imta.fil.markentry.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * This course class is associated to the follow table.
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
@Table("follow")
public class CourseRef {

    @Column("course_id")
    private Integer courseId;

    /**
     * Empty constructor method to instantiate automatically the spring applicaiton
     */
    public CourseRef(){
    }

    /**
     * Constructor method.
     * @param courseId the course id
     */
    public CourseRef(Integer courseId){
        this.courseId = courseId;
    }

    /**
     * Getter CourseId
     * @return courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * Setter CourseId
     * @param courseId the new courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
