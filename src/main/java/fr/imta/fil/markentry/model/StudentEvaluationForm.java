package fr.imta.fil.markentry.model;

public class StudentEvaluationForm {

    private Integer studentId;

    private Integer courseId;

    private Integer evaluation;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }
}
