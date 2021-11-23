package fr.imta.fil.markentry.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
