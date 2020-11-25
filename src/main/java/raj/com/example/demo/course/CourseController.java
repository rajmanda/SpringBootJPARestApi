package raj.com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import raj.com.example.demo.topic.Topic;

import org.springframework.web.bind.annotation.RequestMethod ;



@RestController
public class CourseController {

	@Autowired
	private CourseService courseService ;
	
	@RequestMapping("/topics/{topicId}/cources")
	public List<Course> Courses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId) ;
	}
	
	@RequestMapping("/topics/{topicId}/cources/{id}")
	public Optional<Course> getTopic(@PathVariable String id) {
		return courseService.getCourse(id)  ;
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/cources")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		 course.setTopic(new Topic(topicId, "", ""));
		 courseService.addCourse(course, topicId)  ;
	}
	
	//@RequestMapping(method=RequestMethod.POST, value="/Courses", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		System.out.println("updating course - " + course.toString());
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course)  ;
		System.out.println("updated course - " + course.toString());
	}
	
	//@RequestMapping(method=RequestMethod.POST, value="/Courses", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void delteTopic(@PathVariable String id) {		
		courseService.deleteCourse(id)  ;
	}
	
	
}
