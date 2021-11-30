package fr.imta.fil.markentry.student;
import fr.imta.fil.markentry.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTests {

    @Test
    void getIdTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        assertEquals(2, julio.getId());
    }

    @Test
    void getIdTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        assertEquals(1, yoann.getId());
    }

    @Test
    void setIdTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        julio.setStudentId(4);
        assertEquals(4, julio.getId());
    }

    @Test
    void setIdTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        yoann.setStudentId(3);
        assertEquals(3, yoann.getId());
    }

    @Test
    void getFirstnameTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        assertEquals("Jules", julio.getFirstname());
    }

    @Test
    void getFirstnameTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        assertEquals("Yoann", yoann.getFirstname());
    }

    @Test
     void setFirstnameTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        julio.setFirstname("Yoann");
        assertEquals("Yoann", julio.getFirstname());
    }

    @Test
     void setFirstnameTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        yoann.setFirstname("Jules");
        assertEquals("Jules", yoann.getFirstname());
    }

    @Test
     void getLastnameTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        assertEquals("Carpio", julio.getLastname());
    }

    @Test
     void getLastnameTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        assertEquals("Périquoi", yoann.getLastname());
    }

    @Test
     void setLastnameTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        julio.setLastname("Périquoi");
        assertEquals("Périquoi", julio.getLastname());
    }

    @Test
     void setLastnameTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        yoann.setLastname("Carpio");
        assertEquals("Carpio", yoann.getLastname());
    }

    @Test
     void isNewTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        assertTrue(julio.isNew());
    }

    @Test
     void isNewTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        assertTrue(yoann.isNew());
    }

    @Test
     void setNewTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        julio.setNew(false);
        assertFalse(julio.isNew());
    }

    @Test
     void setNewTest2() {
        Student yoann = new Student(1, "Yoann", "Périquoi");
        yoann.setNew(true);
        assertNotEquals(false, yoann.isNew());
    }

    @Test
     void toStringTest1() {
        Student julio = new Student(2, "Jules", "Carpio");
        assertEquals("2 : Jules Carpio", julio.toString());
    }


}
