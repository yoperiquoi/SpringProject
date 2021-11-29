package fr.imta.fil.markentry.follow;

import fr.imta.fil.markentry.student.Student;
import fr.imta.fil.markentry.student.StudentEvaluationForm;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends CrudRepository<Student,Integer> {

    @Query("UPDATE follow f SET evaluation = :mark WHERE f.student_id = :student_id AND f.course_id = 8 RETURNING *;")
    StudentEvaluationForm modifyStudentEvaluation(@Param("mark") Integer mark, @Param("student_id") Integer studentId, @Param("course_id") Integer courseId);
}
