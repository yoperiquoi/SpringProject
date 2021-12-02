package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.model.StudentEvaluationForm;
import fr.imta.fil.markentry.model.StudentResponse;
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
public class StudentControllerTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();
    String CONTROLLER_BASE_URL = "http://localhost:8080/api/student";

    @Test
    void test_get_student(){
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/students/" + 2).build();
        ResponseEntity<StudentResponse> response = testRestTemplate.exchange(request, StudentResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test_get_students(){
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/students").build();
        ResponseEntity<String> response = testRestTemplate.exchange(request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void test_get_studentCourses(){
        RequestEntity<?> request = RequestEntity.get(CONTROLLER_BASE_URL + "/studentCourses?firstname=Matteo&lastname=ORDRENNEAU").build();
        ResponseEntity<StudentResponse> response = testRestTemplate.exchange(request, StudentResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }



}
