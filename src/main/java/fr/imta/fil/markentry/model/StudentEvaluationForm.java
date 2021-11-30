package fr.imta.fil.markentry.model;

/**
 * This student class used for change the evaluation.
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
public class StudentEvaluationForm {

    private Integer studentId;

    private Integer courseId;

    private Integer evaluation;

    /**
     * Getter of student id
     * @return a student id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * Setter of student id
     * @param studentId the new student id
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    /**
     * Getter of courseId
     * @return the courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * Setter courseId
     * @param courseId the new courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * Getter of the evaluation
     * @return the evaluation
     */
    public Integer getEvaluation() {
        return evaluation;
    }

    /**
     * Setter of evaluation
     * @param evaluation the new evaluation
     */
    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }
}
