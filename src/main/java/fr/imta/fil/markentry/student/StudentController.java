package fr.imta.fil.markentry.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
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
