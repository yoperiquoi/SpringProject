package fr.imta.fil.markentry.course;
import fr.imta.fil.markentry.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class CourseTests {

    @Test
     void getIdTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        assertEquals(12, mathematiques.getId());
    }

    @Test
     void getIdTest2() {
        Course anglais = new Course(3, "Anglais", "Expression");
        assertEquals(3, anglais.getId());
    }

    @Test
     void isNewTest1() {
        Course anglais = new Course(3, "Anglais", "Expression");
        assertTrue(anglais.isNew());
    }

    @Test
     void isNewTest2() {
        Course anglais = new Course(3, "Anglais", "Expression");
        assertNotEquals(false, anglais.isNew());
    }

    @Test
     void setCourseIdTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setCourseId(1);
        assertEquals(1, mathematiques.getId());
    }

    @Test
     void setCourseIdTest2() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setCourseId(143);
        assertNotEquals(12, mathematiques.getId());
    }

    @Test
     void getTitleTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        assertEquals("Mathematiques", mathematiques.getTitle());
    }

    @Test
     void getTitleTest2() {
        Course anglais = new Course(3, "Anglais", "Expression");
        assertEquals("Anglais", anglais.getTitle());
    }

    @Test
     void setTitleTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setTitle("Mathematiques discretes");
        assertEquals("Mathematiques discretes", mathematiques.getTitle());
    }

    @Test
     void setTitleTest2() {
        Course anglais = new Course(3, "Anglais", "Expression");
        anglais.setTitle("Anglais euro");
        assertEquals("Anglais euro", anglais.getTitle());
    }


    @Test
     void getDescriptionTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        assertEquals("Algèbre linéaire", mathematiques.getDescription());
    }

    @Test
     void getDescriptionTest2() {
        Course anglais = new Course(3, "Anglais", "Expression");
        assertEquals("Expression", anglais.getDescription());
    }

    @Test
     void setDescriptionTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setDescription("Matrice et espace vectoriel");
        assertEquals("Matrice et espace vectoriel", mathematiques.getDescription());
    }

    @Test
     void setDescriptionTest2() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setDescription("Matrice et espace vectoriel");
        assertNotEquals("Algèbre linéaire", mathematiques.getDescription());
    }

    @Test
     void setIsNewTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setNew(false);
        assertFalse(mathematiques.isNew());
    }

    @Test
     void setIsNewTest2() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        mathematiques.setNew(true);
        assertNotEquals(false, mathematiques.isNew());
    }

    @Test
     void toStringTest1() {
        Course mathematiques = new Course(12, "Mathematiques", "Algèbre linéaire");
        assertEquals("12 : Mathematiques Algèbre linéaire", mathematiques.toString());
    }



}
