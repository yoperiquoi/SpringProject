package fr.imta.fil.markentry.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("follow")
public class CourseRef {

    @Column("course_id")
    private Integer courseId;

    public CourseRef(){
    }

    public CourseRef(Integer courseId){
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}