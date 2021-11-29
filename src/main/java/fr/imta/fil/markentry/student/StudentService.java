package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.course.Course;
import fr.imta.fil.markentry.course.CourseRepository;
import fr.imta.fil.markentry.course.CourseResponse;
import fr.imta.fil.markentry.course.CourseService;
import fr.imta.fil.markentry.follow.CourseRef;
import fr.imta.fil.markentry.follow.FollowRepository;
import fr.imta.fil.markentry.follow.StudentRef;
import fr.imta.fil.markentry.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    private FollowRepository followRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, FollowRepository followRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.followRepository = followRepository;
    }

    public Optional<Student> findStudentById(Integer id){
        return studentRepository.findById(id);
    }

    public Optional<Student> findStudentByFirstnameAndLastName(String firstname, String lastname){
        return studentRepository.findStudentByName(firstname, lastname);
    }

    public List<Student> findAllStudents() {
        return ListUtils.asList(studentRepository.findAll());
    }

    public List<Student> findAllStudentsWithEvaluationLessOrEqual(Integer mark){
        return ListUtils.asList(studentRepository.findAllStudentWithMarkLessOrEqual(mark));
    }

    public boolean modifyStudentEvaluation(StudentEvaluationForm studentEvaluationForm){
        try {
            this.followRepository.modifyStudentEvaluation(studentEvaluationForm.getEvaluation(), studentEvaluationForm.getStudentId(), studentEvaluationForm.getCourseId());
            return true;
        } catch(Exception e){
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    public StudentResponse ConvertStudentToStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse(student.getId(), student.getFirstname(), student.getLastname());
        Set<Course> courses = new HashSet<>();
        for(CourseRef courseRef : student.getCourses()){
            Optional<Course> findCourse = this.courseRepository.findById(courseRef.getCourseId());
            findCourse.ifPresent(courses::add);
        }
        studentResponse.setCourses(courses);
        return studentResponse;
    }
}
