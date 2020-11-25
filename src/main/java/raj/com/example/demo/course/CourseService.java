package raj.com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository ;
	
	public List<Course> getAllCourses(String topicId){
		ArrayList<Course> Courses  = new ArrayList<Course>();
		
	    for ( Object o : courseRepository.findByTopicId(topicId) ) 
              Courses.add((Course) o);
             
		return Courses ;
	}
	
	public Optional<Course> getCourse(String courseId) {
	   return courseRepository.findById(courseId) ;
	   
	}

	public void addCourse(Course course, String topicId) {
		courseRepository.save(course) ;
	}

	public void updateCourse(Course course) {
		courseRepository.save(course) ;
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
