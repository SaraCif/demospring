package com.spring.demospring.service.user;

import org.springframework.stereotype.Service;

import com.spring.demospring.dto.ResponseModel;
import com.spring.demospring.dto.UserModel;
import com.spring.demospring.service.exception.UserException;

@Service
public interface UserService {
	
	ResponseModel createUser(UserModel user);

	ResponseModel deleteUser(Long id);
	
	UserModel getUserById(Long id);

	ResponseModel updateUser(Long id, UserModel user);

}
