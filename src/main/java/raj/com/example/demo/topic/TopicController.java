package raj.com.example.demo.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod ;



@RestController
public class TopicController {

	@Autowired
	private TopicService topicService ;
	
	@RequestMapping("/topics")
	public List<Topic> topics() {
		return topicService.getAllTopics()  ;
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id)  ;
	}

	//@RequestMapping(method=RequestMethod.POST, value="/topics", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		 topicService.addTopic(topic)  ;
	}
	
	//@RequestMapping(method=RequestMethod.POST, value="/topics", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {		
		topicService.updateTopic(id, topic)  ;
	}
	
	//@RequestMapping(method=RequestMethod.POST, value="/topics", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void delteTopic(@PathVariable String id) {		
		topicService.deleteTopic(id)  ;
	}
	
	
}
