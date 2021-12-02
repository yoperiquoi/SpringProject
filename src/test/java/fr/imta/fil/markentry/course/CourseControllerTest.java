package fr.imta.fil.markentry.course;


import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.model.CourseResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@PropertySource("application-test.properties")
@Transactional //fin de test rollback tout
@ActiveProfiles("test")
public class CourseControllerTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();
    String CONTROLLER_BASE_URL = "http://localhost:8080/api/course";

    /*
    @Test
    void tryGetTables(){
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/tables").build();
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        System.out.println(response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    */

    @Test
    void test_get_course(){
        int courseId = 2;
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/courses/" + 2).build();
        ResponseEntity<Course> response = testRestTemplate.exchange(request, Course.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test_get_courses(){
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/courses").build();
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
