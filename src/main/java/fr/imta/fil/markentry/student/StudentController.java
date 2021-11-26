package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.course.Course;
import fr.imta.fil.markentry.course.CourseController;
import fr.imta.fil.markentry.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    private CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService){
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> findStudentId(@PathVariable("studentId") Integer studentId){
        Optional<Student> findStudentById = studentService.findStudentById(studentId);
        return findStudentById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentService.findAllStudents();
    }

    @GetMapping("/studentCourses")
    public ResponseEntity<Student> findStudentByNameAndFollowedCourses(@RequestParam String firstname, @RequestParam String lastname) {
        // TODO Matteo
        return ResponseEntity.ok().build();
    }
}
