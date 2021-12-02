package fr.imta.fil.markentry.repository;

import fr.imta.fil.markentry.model.Student;
import fr.imta.fil.markentry.model.StudentEvaluationForm;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FollowRepository extends CrudRepository<Student,Integer> {

    @Query("UPDATE follow f SET evaluation = :mark WHERE f.student_id = :student_id AND f.course_id = :course_id RETURNING *;")
    StudentEvaluationForm modifyStudentEvaluation(@Param("mark") Integer mark, @Param("student_id") Integer studentId, @Param("course_id") Integer courseId);

    @Query("SELECT evaluation FROM follow f WHERE f.student_id = :student_id AND f.course_id = :course_id;")
    Optional<Integer> getStudentEvaluation(@Param("student_id") Integer studentId, @Param("course_id") Integer courseId);
}
