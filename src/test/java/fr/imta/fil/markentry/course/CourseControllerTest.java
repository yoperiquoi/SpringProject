package fr.imta.fil.markentry.course;


import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.model.CourseForm;
import fr.imta.fil.markentry.model.CourseResponse;
import fr.imta.fil.markentry.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@PropertySource("application-test.properties")
@Transactional //at the end of text we rollback
@ActiveProfiles("test")
public class CourseControllerTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();
    String CONTROLLER_BASE_URL = "http://localhost:8080/api/course";

    @Test
    void test_get_course(){
        int courseId = 1;
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/courses/" + courseId).build();
        ResponseEntity<Course> response = testRestTemplate.exchange(request, Course.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test_get_courses(){
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/courses").build();
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test_add_course(){
        RequestEntity<?> request = RequestEntity.post(CONTROLLER_BASE_URL + "/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"courseId\":2,\"title\":\"test\",\"description\":\"test\",\"students\":[{\"studentId\":13,\"firstname\":\"test\",\"lastname\":\"test\"},{\"studentId\":14,\"firstname\":\"test\",\"lastname\":\"test\"}]}");
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test_delete_course(){
        RequestEntity<?> request = RequestEntity.delete(CONTROLLER_BASE_URL + "/courses/" + 2).build();
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
