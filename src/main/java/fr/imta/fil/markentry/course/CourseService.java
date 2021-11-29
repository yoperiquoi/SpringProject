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


    public String addCourse(int id, String title, String description){
        try{
            courseRepository.save(new Course(id,title,description));
        }catch (Exception e){
            return "An error has occured : " + e.getMessage();
        }
        return "The course have been added";
    }

    public List<Course> findCoursesByStudent(Student student) { return null;}

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

}
