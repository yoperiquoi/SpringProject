package fr.imta.fil.markentry.course;

import fr.imta.fil.markentry.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Optional<Course> findCourseById(int id){return courseRepository.findById(id);}

    public List<Course> findAllCourses(){
        return ListUtils.asList(courseRepository.findAll());
    }

    public String addCourse(Course course){
        try{
            courseRepository.save(course);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return "An error has occured : " + e.getMessage();
        }
        return "The course have been added";
    }

}
