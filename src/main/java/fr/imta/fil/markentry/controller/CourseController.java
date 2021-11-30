package fr.imta.fil.markentry.controller;


import fr.imta.fil.markentry.model.Course;
import fr.imta.fil.markentry.model.CourseForm;
import fr.imta.fil.markentry.model.CourseResponse;
import fr.imta.fil.markentry.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class is the course controller which use a course service
 * @author Yoann Periquoi, Matteo Ordrenneau, Jules Carpio.
 * @version 1.0
 * @since 29/11/2021
 *
 */
@RestController
@RequestMapping("/api/course")
public class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    private CourseService courseService;

    /**
     * Constructor method.
     * @param courseService - a course service
     */
    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    /**
     * Method which use a course service to find the course according to it id.
     * @param id the course id
     * @return the course
     */
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseResponse> findCourseId(@PathVariable("courseId") int id){
        Optional<Course> courseById = courseService.findCourseById(id);
        if(courseById.isPresent()){
            LOGGER.info("Get the course " + id);
            return ResponseEntity.ok(courseService.ConvertCourseToCourseResponse(courseById.get()));
        } else {
            LOGGER.warn("The course with id " + id + " has not been found");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Allows to get all the courses
     * @return all the courses
     */
    @GetMapping("/courses")
    public List<CourseResponse> findAllCourse(){
        LOGGER.info("Get all the courses");
        List<Course> courses = courseService.findAllCourses();
        return courses.stream().map(courseService::ConvertCourseToCourseResponse).collect(Collectors.toList());//collect allows to stock the course in a list
    }

    /**
     * Allows to add a course thanks a request
     * @param courseForm the course request
     * @return a response entity
     */
    @PostMapping("/courses")
    public ResponseEntity<String> addCourse(@RequestBody CourseForm courseForm){
        if(courseService.validateRequestBody(courseForm)){
            try {
                boolean added = courseService.addCourse(courseForm);
                if(added) {
                    LOGGER.info("The courses " + courseForm.getCourseId() + " has been added");
                    return ResponseEntity.ok("The courses " + courseForm.getCourseId() + " has been added");
                } else {
                    LOGGER.warn("The courses " + courseForm.getCourseId() + " has not been added");
                    return ResponseEntity.ok("The courses " + courseForm.getCourseId() + " has not been added");
                }
            } catch (Exception e){
                LOGGER.error("There has been an error in addCourse : " + e.getMessage());
                return ResponseEntity.badRequest().build();
            }
        } else {
            LOGGER.error("Error during the validation of RequestBody for : add course");
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Allows to delete a course
     * @param id the deleted course
     * @return ResponseEntity
     */
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> delete(@PathVariable("courseId") Integer id){
        if(courseService.findCourseById(id).isPresent()){
            return ResponseEntity.ok(courseService.deleteCourseById(id));
        } else {
            LOGGER.warn("Non existing course for id " + id);
            return ResponseEntity.notFound().build();
        }
    }
}
