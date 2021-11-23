package fr.imta.fil.markentry.course;


import fr.imta.fil.markentry.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> findCourseId(@PathVariable("courseId") int id){
        Optional<Course> courseById = courseService.findCourseById(id);
        return courseById.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/courses")
    public List<Course> findAllCourse(){
         return courseService.findAllCourses();
    }

    @PostMapping("/courses")
    public String addCourse(@RequestBody Course course){
         return courseService.addCourse(course);
    }

}
