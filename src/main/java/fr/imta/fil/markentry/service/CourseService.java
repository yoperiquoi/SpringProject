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

@Service
public class CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseService.class);

    private CourseRepository courseRepository;

    private StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository){
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Optional<Course> findCourseById(int id){
        return courseRepository.findById(id);
    }

    public List<Course> findAllCourses(){
        return ListUtils.asList(courseRepository.findAll());
    }

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

    public CourseResponse ConvertCourseToCourseResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse(course.getId(), course.getTitle(), course.getDescription());
        Set<Student> students = new HashSet<>();
        for(StudentRef studentRef : course.getStudents()){
            Optional<Student> findStudent = this.studentRepository.findById(studentRef.getStudentId());
            findStudent.ifPresent(students::add);
        }
        courseResponse.setStudents(students);
        return courseResponse;
    }

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
