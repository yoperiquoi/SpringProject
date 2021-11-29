package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.course.Course;
import fr.imta.fil.markentry.course.CourseController;
import fr.imta.fil.markentry.course.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentResponse> findStudentId(@PathVariable("studentId") Integer studentId){
        Optional<Student> findStudentById = studentService.findStudentById(studentId);
        if(findStudentById.isPresent()){
            LOGGER.info("Get the student " + studentId);
            return ResponseEntity.ok(this.studentService.ConvertStudentToStudentResponse(findStudentById.get()));
        } else {
            LOGGER.warn("The student with id " + studentId + " has not been found");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/students")
    public List<StudentResponse> findAllStudent(){
        LOGGER.info("Get all the students");
        List<Student> students = studentService.findAllStudents();
        return students.stream().map(studentService::ConvertStudentToStudentResponse).collect(Collectors.toList());
    }

    @GetMapping("/studentCourses")
    public ResponseEntity<StudentResponse> findStudentByNameAndFollowedCourses(@RequestParam String firstname, @RequestParam String lastname) {
        Optional<Student> findStudent = studentService.findStudentByFirstnameAndLastName(firstname, lastname);
        if(findStudent.isPresent()){
            LOGGER.info("Get student" + firstname + " " + lastname + " and all his associated courses");
            return ResponseEntity.ok(this.studentService.ConvertStudentToStudentResponse(findStudent.get()));
        } else {
            LOGGER.error("Not found student with name : " + firstname + " " + lastname);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/studentMarkLessOrEqual")
    public List<StudentResponse> findAllStudentsWithEvaluationLessOrEqual(@RequestParam Integer mark){
        LOGGER.info("Get all the students with mark less or equals than " + mark);
        List<Student> students = studentService.findAllStudentsWithEvaluationLessOrEqual(mark);
        return students.stream().map(studentService::ConvertStudentToStudentResponse).collect(Collectors.toList());
    }

    @PatchMapping("/modifyStudentEvaluation")
    public ResponseEntity<String> modifyStudentEvaluation(@RequestBody StudentEvaluationForm studentEvaluationForm){
        if(studentService.modifyStudentEvaluation(studentEvaluationForm)){
            LOGGER.info("Update the evaluation to " + studentEvaluationForm.getEvaluation() + " to student " + studentEvaluationForm.getStudentId() + " on course " + studentEvaluationForm.getCourseId());
            return ResponseEntity.ok("Update the evaluation to " + studentEvaluationForm.getEvaluation() + " to student " + studentEvaluationForm.getStudentId() + " on course " + studentEvaluationForm.getCourseId());
        } else {
            LOGGER.error("There has been an error during the update");
            return ResponseEntity.badRequest().build();
        }
    }
}
