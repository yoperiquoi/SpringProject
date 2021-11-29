package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.ApplicationConfig;
import fr.imta.fil.markentry.DatabaseTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = {ApplicationConfig.class, DatabaseTestConfig.class})
@Transactional

public class StudentServiceTest {

    @Autowired
    private StudentService service;

    private static final String CONTROLLER_BASE_URL = "/api/student/";

    @Test
    public void contextLoad(){
        assertThat(service).isNotNull();
    }

    @Test
    void getStudentTest(){
        List<Student> allCourses = service.findAllStudents();
        Assertions.assertEquals(2, allCourses.size());
    }




}