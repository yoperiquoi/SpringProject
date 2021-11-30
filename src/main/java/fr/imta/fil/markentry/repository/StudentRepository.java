package fr.imta.fil.markentry.repository;

import fr.imta.fil.markentry.model.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("SELECT * FROM student s WHERE s.firstname = :firstname AND s.lastname = :lastname;")
    Optional<Student> findStudentByName(@Param("firstname") String firstname, @Param("lastname") String lastname);

    @Query("SELECT * FROM student where student_id = (SELECT student_id Unique FROM Follow WHERE evaluation <= :mark);")
    Iterable<Student> findAllStudentWithMarkLessOrEqual(@Param("mark") Integer mark);
}
