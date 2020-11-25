package raj.com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository ;

	/*
	List<Topic> topics  = new ArrayList<> (Arrays.asList(
			new Topic("001", "Core Java",   "Introduction to Core Java"),
			new Topic("002", "Spring Boot", "Introduction to Spring Boot"),
			new Topic("003", "Java Script", "Introduction to Java Script Basics")
			)) ;
	*/
	
	public List<Topic> getAllTopics(){
		ArrayList<Topic> topics  = new ArrayList<Topic>();
		//topicRepository.findAll().forEach(newtopics::add);
		
	    for ( Object o : topicRepository.findAll() ) 
              topics.add((Topic) o);
             
		return topics ;
	}
	
	public Optional<Topic> getTopic(String topicId) {
		//return topics.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
	   return topicRepository.findById(topicId) ;
	   
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic) ;
		
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic) ;
		
		/*
		for(int i = 0 ; i < topics.size(); i++) {
			Topic t = topics.get(i) ; 
			if(t.getId().equals(id)) {
				topics.set(i, topic) ;	
				return ; 
			}
		}
		*/
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getClass().equals(id)) ;
		topicRepository.deleteById(id);
	}
}
