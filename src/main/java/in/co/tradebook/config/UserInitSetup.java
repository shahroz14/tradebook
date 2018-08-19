package in.co.tradebook.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import in.co.tradebook.service.UserService;
import in.co.tradecart.entities.User;

@Component
public class UserInitSetup implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		logger.info("User Setup strated");
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = mapper.readValue(ResourceUtils.getFile("classpath:UserSetup.json"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, User.class));
		userList.stream().forEach(u -> userService.addUser(u));
	}
	
}
