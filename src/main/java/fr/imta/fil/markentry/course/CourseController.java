package fr.imta.fil.markentry.course;


import fr.imta.fil.markentry.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CourseResponse> findCourseId(@PathVariable("courseId") int id){
        Optional<Course> courseById = courseService.findCourseById(id);
        return courseById.map(
                course -> ResponseEntity.ok(courseService.ConvertCourseToCourseResponse(course)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/courses")
    public List<CourseResponse> findAllCourse(){
        List<Course> courses = courseService.findAllCourses();
        return courses.stream().map(courseService::ConvertCourseToCourseResponse).collect(Collectors.toList());
    }

    @PostMapping("/courses")
    public String addCourse(@RequestBody Course request){
        return courseService.addCourse(request.getId(),request.getTitle(),request.getDescription());
    }

}
