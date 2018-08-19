package in.co.tradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.co.tradebook.repositories.UserRepository;
import in.co.tradecart.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void addUser(User user) {
		if(userRepository.findByUsername(user.getUsername()) == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}
	}

}
