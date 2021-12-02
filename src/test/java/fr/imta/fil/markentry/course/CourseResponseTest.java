package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.model.CourseRef;
import fr.imta.fil.markentry.model.CourseResponse;
import fr.imta.fil.markentry.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseResponseTest {


    @Test
    void getIdTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        assertEquals(12, mathematiques.getCourseId());
    }

    @Test
    void setIdTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setCourseId(4);
        assertEquals(4, mathematiques.getCourseId());
    }

    @Test
    void getDescriptionTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        assertEquals("Algèbre linéaire", mathematiques.getDescription());
    }

    @Test
    void getTitleTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        assertEquals("Mathematiques", mathematiques.getTitle());
    }

    @Test
    void setDescriptionTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setDescription("Geometrie");
        assertEquals("Geometrie", mathematiques.getDescription());
    }

    @Test
    void setTitleTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setTitle("Mathematique discretes");
        assertEquals("Mathematique discretes", mathematiques.getTitle());
    }

    @Test
    void setStudentsTest1() {
        CourseResponse mathematiques = new CourseResponse(12, "Mathematiques", "Algèbre linéaire");
        Set<Student> students = new HashSet<>();
        Student yoann = new Student(1, "Yoann", "Periquoi");
        Student matteo = new Student(2, "Matteo", "Ordrenneau");
        students.add(yoann);
        students.add(matteo);
        mathematiques.setStudents(students);
        assertEquals(students , mathematiques.getStudents());
    }




}
