package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.model.CourseForm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseFormTest {

    @Test
    void getIdTest1() {
        CourseForm mathematiques = new CourseForm();
        mathematiques.setCourseId(12);
        assertEquals(12, mathematiques.getCourseId());
    }

    @Test
    void setIdTest1() {
        CourseForm mathematiques = new CourseForm();
        mathematiques.setCourseId(12);
        assertEquals(12, mathematiques.getCourseId());
    }

}
