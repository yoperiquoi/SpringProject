package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.ApplicationConfig;
import fr.imta.fil.markentry.DatabaseTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = {ApplicationConfig.class, DatabaseTestConfig.class})
@Transactional

public class CourseServiceTest {

    @Autowired
    private CourseService service;

    private static final String CONTROLLER_BASE_URL = "/api/course/";

    @Test
    public void contextLoad(){
        assertThat(service).isNotNull();
    }

    @Test
    void getCourseTest(){
        List<Course> allCourses = service.findAllCourses();
        Assertions.assertEquals(2, allCourses.size());
    }




}

