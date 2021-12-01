package fr.imta.fil.markentry.service;

import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.repository.CourseRepository;
import fr.imta.fil.markentry.model.CourseRef;
import fr.imta.fil.markentry.repository.FollowRepository;
import fr.imta.fil.markentry.model.Student;
import fr.imta.fil.markentry.model.StudentEvaluationForm;
import fr.imta.fil.markentry.repository.StudentRepository;
import fr.imta.fil.markentry.model.StudentResponse;
import fr.imta.fil.markentry.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class is used by the student controller to process data of the repository
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    private FollowRepository followRepository;

    /**
     * Constructor method
     * @param studentRepository the student repository
     * @param courseRepository the course repository to check if course exist
     */
    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, FollowRepository followRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.followRepository = followRepository;
    }

    /**
     * Allows to find a student according to his id
     * @param id the student id
     * @return the student
     */
    public Optional<Student> findStudentById(Integer id){
        return studentRepository.findById(id);
    }

    /**
     * Allows to find a student according to his firtname and lastname
     * @param firstname String
     * @param lastname String
     * @return the student
     */
    public Optional<Student> findStudentByFirstnameAndLastName(String firstname, String lastname){
        return studentRepository.findStudentByName(firstname, lastname);
    }

    /**
     * Allows to get all the students
     * @return the student list
     */
    public List<Student> findAllStudents() {
        return ListUtils.asList(studentRepository.findAll());
    }

    /**
     * Allows to find the students according to their mark
     * @param mark the evalution mark
     * @return the student list
     */
    public List<Student> findAllStudentsWithEvaluationLessOrEqual(Integer mark){
        return ListUtils.asList(studentRepository.findAllStudentWithMarkLessOrEqual(mark));
    }

    /**
     * Allows to modify the student evaluation
     * @param studentEvaluationForm the new student
     * @return boolean
     */
    public boolean modifyStudentEvaluation(StudentEvaluationForm studentEvaluationForm){
        try {
            this.followRepository.modifyStudentEvaluation(studentEvaluationForm.getEvaluation(), studentEvaluationForm.getStudentId(), studentEvaluationForm.getCourseId());
            return true;
        } catch(Exception e){
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    /**
     * Allows to convert a student to a reponse student
     * @param student the student
     * @return the response student with list of courses
     */
    public StudentResponse ConvertStudentToStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse(student.getId(), student.getFirstname(), student.getLastname());
        Set<Course> courses = new HashSet<>();
        HashMap<Integer, Integer> evaluations = new HashMap<>();
        for(CourseRef courseRef : student.getCourses()){
            Optional<Course> findCourse = this.courseRepository.findById(courseRef.getCourseId());
            findCourse.ifPresent(courses::add);
            Optional<Integer> findEvaluation = this.followRepository.getStudentEvaluation(student.getId(), courseRef.getCourseId());
            findEvaluation.ifPresent(integer -> evaluations.put(courseRef.getCourseId(), integer));
        }
        studentResponse.setCourses(courses);
        studentResponse.setEvaluation(evaluations);
        return studentResponse;
    }
}
