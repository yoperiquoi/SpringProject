package fr.imta.fil.markentry.repository;

import fr.imta.fil.markentry.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {
}
