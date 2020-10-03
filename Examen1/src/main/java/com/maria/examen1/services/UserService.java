package com.maria.examen1.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.maria.examen1.models.User;
import com.maria.examen1.repositories.UserRepository;


@Service
public class UserService {

	 private final UserRepository userRepository;
	    
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	    
	    // registrar usuario
	    public User registerUser(User user) {
	        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	        user.setPassword(hashed);
	        return userRepository.save(user);
	    }
	    
	    // encontrar un usuario por su email
	    public User findByEmail(String email) {
	       return  userRepository.findByEmail(email);
	    }
	    
	    // encontrar un usuario por su id
	    public User findUserById(Long id) {
	    	Optional<User> u = userRepository.findById(id);
	    	
	    	if(u.isPresent()) {
	            return u.get();
	    	} else {
	    	    return null;
	    	}
	    }
	    
	    // autenticar al usuario
	    public boolean authenticateUser(String email, String password) {
	        
	        User user = userRepository.findByEmail(email);
	        if(user == null) {
	            return false;
	        } else {
	            if(BCrypt.checkpw(password, user.getPassword())) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    }
	    
	    public User updateUser(Long id, String name,String email,String password,String passwordConfirmation) {
	    	Optional<User> optionalUser = userRepository.findById(id);
	    	if(optionalUser.isPresent()) {
	    		User up = optionalUser.get();
	    		
	    		up.setName(name);
	    		up.setEmail(email);
	    		up.setPassword(password);
	    		up.setPasswordConfirmation(passwordConfirmation);
	    		return userRepository.save(up);
	    	}else {
	    		return null;
	    	}
	    }

		public List<User> allUsers(){
			return (List<User>) userRepository.findAll();
		}

		public void updateUser(User u) {
			    	userRepository.save(u);
			    }
		}
