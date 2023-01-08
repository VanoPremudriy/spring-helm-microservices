package ru.mirea.authorizationservice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import ru.mirea.authorizationservice.models.UserTO;
import ru.mirea.authorizationservice.service.UserService;

import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger("KafkaApp");

	@Value("${message.topic.name}")
	private String topicName;

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	UserService userService;

	public UserController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@RequestMapping(path="/user/create")
	public UserTO createUser(@RequestBody UserTO userTo) {
		
		return userService.saveUser(userTo);
	}
	
	@RequestMapping(path="/user/get",method=RequestMethod.GET)
	public UserTO getUser(@RequestParam long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/login")
	public String login(@RequestParam("access_token") String accessToken){
		kafkaTemplate.send(topicName, accessToken);
		return "Success";
	}
}
