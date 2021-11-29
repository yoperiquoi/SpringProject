package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.course.Course;
import fr.imta.fil.markentry.course.CourseController;
import fr.imta.fil.markentry.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
    public ResponseEntity<StudentResponse> findStudentId(@PathVariable("studentId") Integer studentId){
        Optional<Student> findStudentById = studentService.findStudentById(studentId);
        return findStudentById.map(
                student -> ResponseEntity.ok(this.studentService.ConvertStudentToStudentResponse(student)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/students")
    public List<StudentResponse> findAllStudent(){
        List<Student> students = studentService.findAllStudents();
        return students.stream().map(studentService::ConvertStudentToStudentResponse).collect(Collectors.toList());
    }

    @GetMapping("/studentCourses")
    public ResponseEntity<StudentResponse> findStudentByNameAndFollowedCourses(@RequestParam String firstname, @RequestParam String lastname) {
        Optional<Student> findStudent = studentService.findStudentByFirstnameAndLastName(firstname, lastname);
        return findStudent.map(
                student -> ResponseEntity.ok(this.studentService.ConvertStudentToStudentResponse(student)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/studentMarkLessOrEqual")
    public List<StudentResponse> findAllStudentsWithEvaluationLessOrEqual(@RequestParam Integer mark){
        List<Student> students = studentService.findAllStudentsWithEvaluationLessOrEqual(mark);
        return students.stream().map(studentService::ConvertStudentToStudentResponse).collect(Collectors.toList());
    }
}
