package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.follow.StudentRef;
import fr.imta.fil.markentry.student.Student;
import fr.imta.fil.markentry.student.StudentRepository;
import fr.imta.fil.markentry.student.StudentResponse;
import fr.imta.fil.markentry.student.StudentService;
import fr.imta.fil.markentry.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

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
    public String addCourse(CourseForm courseForm) {
        if(this.courseRepository.findById(courseForm.getCourseId()).isPresent()){
            return "Un cours est déjà référencé à cet ID";
        } else {
            try {
                Course course = new Course(courseForm.getCourseId(), courseForm.getTitle(), courseForm.getDescription());
                for(Student student : courseForm.getStudents()){
                    if(this.studentRepository.findById(student.getId()).isEmpty()){
                        this.studentRepository.save(student);
                    }
                    course.addStudent(new StudentRef(student.getId()));
                }
                courseRepository.save(course);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "Le cours à bien été ajouté ainsi que les élèves assignés";

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
