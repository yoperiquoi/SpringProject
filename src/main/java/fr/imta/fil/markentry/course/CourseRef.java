package fr.imta.fil.markentry.course;

import org.springframework.data.relational.core.mapping.Table;

@Table("follow")
public class CourseRef {

    private Integer courseId;

    public CourseRef() {
    }

    public CourseRef(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
