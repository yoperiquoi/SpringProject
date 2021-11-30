package fr.imta.fil.markentry.service;

import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.model.CourseForm;
import fr.imta.fil.markentry.repository.CourseRepository;
import fr.imta.fil.markentry.model.CourseResponse;
import fr.imta.fil.markentry.model.StudentRef;
import fr.imta.fil.markentry.model.Student;
import fr.imta.fil.markentry.repository.StudentRepository;
import fr.imta.fil.markentry.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * This class is used by the course controller to process data of the repository
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
@Service
public class CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseService.class);

    private CourseRepository courseRepository;

    private StudentRepository studentRepository;

    /**
     * Constructor
     * @param courseRepository the course repository
     * @param studentRepository the student repository to mainly find student id
     */
    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository){
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Allows to find a course knowing its id
     * @param id the id of the intended course
     * @return the course
     */
    public Optional<Course> findCourseById(int id){
        return courseRepository.findById(id);
    }

    /**
     * Allows to find and return all the course as a list
     * @return a list of course
     */
    public List<Course> findAllCourses(){
        return ListUtils.asList(courseRepository.findAll());
    }

    /**
     * Allows to add a course, and add the student id in if the student exist
     * @param courseForm the course to add
     * @return the statut of the transactionnal method
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addCourse(CourseForm courseForm) throws Exception{
        if(this.courseRepository.findById(courseForm.getCourseId()).isPresent()){
            LOGGER.warn("A course with id " + courseForm.getCourseId() + " already exits");
            throw new Exception("A course with id " + courseForm.getCourseId() + " already exits");
        } else {
            try {
                Course course = new Course(courseForm.getCourseId(), courseForm.getTitle(), courseForm.getDescription());
                for(Student student : courseForm.getStudents()){
                    if(this.studentRepository.findById(student.getId()).isEmpty()){
                        LOGGER.info("The student with id " + student.getId() + " has been added");
                        this.studentRepository.save(student);
                    }
                    course.addStudent(new StudentRef(student.getId()));
                }
                courseRepository.save(course);
                return true;
            } catch (Exception e) {
                throw new Exception("An error occured during adding the course " + courseForm.getCourseId() + " : " + e.getMessage());
            }
        }
    }

    /**
     * Allows to delete a course
     * @param id the course id
     * @return string
     */
    public String deleteCourseById(Integer id){
        try {
            courseRepository.deleteById(id);
            LOGGER.info("The course " + id + " has been deleted");
        } catch (Exception e) {
            LOGGER.error("There has been an error deleting the course " + id + " : " + e.getMessage());
            return "Un erreur est survenue : " + e.getMessage();
        }
        return "Le cours à été supprimé";
    }

    /**
     * Allows to convert the course to a response course
     * @param course the course to convert
     * @return the courseResponse associated to the course
     */
    public CourseResponse ConvertCourseToCourseResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse(course.getId(), course.getTitle(), course.getDescription());//Obligé de faire ça car nous ne pouvons renvoyer le course objet
        Set<Student> students = new HashSet<>();
        for(StudentRef studentRef : course.getStudents()){
            Optional<Student> findStudent = this.studentRepository.findById(studentRef.getStudentId());
            findStudent.ifPresent(students::add);
        }
        courseResponse.setStudents(students);
        return courseResponse;
    }

    /**
     * Method which allows to check if every content is present in the request.
     * @param courseForm the request course
     * @return a boolean
     */
    public boolean validateRequestBody(CourseForm courseForm) {
        boolean valid = (
            courseForm.getCourseId() != null
            && courseForm.getTitle() != null
            && courseForm.getDescription() != null
            && courseForm.getStudents() != null
        );
        if(courseForm.getStudents() != null) {
            for(Student student : courseForm.getStudents()){
                if(student.getId() == null || student.getFirstname() == null || student.getLastname() == null){
                    return false;
                }
            }
        }
        return valid;
    }

}
