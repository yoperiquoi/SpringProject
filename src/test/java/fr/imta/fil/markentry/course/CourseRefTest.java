package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.model.CourseRef;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseRefTest {

    @Test
    void getIdTest1() {
        CourseRef mathematiques = new CourseRef(12);
        assertEquals(12, mathematiques.getCourseId());
    }

    @Test
    void getIdTest2() {
        CourseRef anglais = new CourseRef(2);
        assertEquals(2, anglais.getCourseId());
    }


    @Test
    void setIdTest1() {
        CourseRef mathematiques = new CourseRef(12);
        mathematiques.setCourseId(3);
        assertEquals(3, mathematiques.getCourseId());
    }

    @Test
    void setIdTest2() {
        CourseRef anglais = new CourseRef(2);
        anglais.setCourseId(9);
        assertEquals(9, anglais.getCourseId());
    }


}
