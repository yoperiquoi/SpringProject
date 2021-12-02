package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.model.CourseResponse;
import fr.imta.fil.markentry.model.Student;
import fr.imta.fil.markentry.model.StudentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentResponseTest {

    @Test
    void getIdTest1() {
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        assertEquals(2, julio.getStudentId());
    }

    @Test
    void setIdTest1() {
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        julio.setStudentId(4);
        assertEquals(4, julio.getStudentId());
    }

    @Test
    void getFirstnameTest1() {
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        assertEquals("Jules", julio.getFirstname());
    }

    @Test
    void setFirstnameTest1() {
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        julio.setFirstname("Julio");
        assertEquals("Julio", julio.getFirstname());
    }

    @Test
    void getLastnameTest1() {
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        assertEquals("Carpio", julio.getLastname());
    }

    @Test
    void setLastnameTest1() {
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        julio.setLastname("Di Caprio");
        assertEquals("Di Caprio", julio.getLastname());
    }

    @Test
    void setCourseTest1(){
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        Set<Course> courses = new HashSet<>();
        Course maths = new Course(1, "Mathematiques", "Geometrie");
        courses.add(maths);
        julio.setCourses(courses);
        assertEquals(courses , julio.getCourses());
    }

    @Test
    void setEvaluationTest1(){
        StudentResponse julio = new StudentResponse(2, "Jules", "Carpio");
        HashMap<Integer, Integer> notes = new HashMap<>();
        notes.put(1, 16);
        julio.setEvaluation(notes);
        assertEquals(notes , julio.getEvaluation());
    }




}
