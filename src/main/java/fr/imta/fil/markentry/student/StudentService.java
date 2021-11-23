package fr.imta.fil.markentry.student;

import fr.imta.fil.markentry.course.CourseRepository;
import fr.imta.fil.markentry.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findStudentById(Integer id){ return studentRepository.findById(id); }

    public List<Student> findAllStudents() { return ListUtils.asList(studentRepository.findAll());}
}
