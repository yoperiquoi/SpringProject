package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.model.Student;
import fr.imta.fil.markentry.model.StudentRef;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRefTest {

    @Test
    void getIdTest1() {
        StudentRef julio = new StudentRef(2);
        assertEquals(2, julio.getStudentId());
    }

    @Test
    void setIdTest1() {
        StudentRef julio = new StudentRef(2);
        julio.setStudentId(4);
        assertEquals(4, julio.getStudentId());
    }

}
