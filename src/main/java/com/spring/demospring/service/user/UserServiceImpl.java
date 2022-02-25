package com.spring.demospring.service.user;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demospring.dto.ResponseModel;
import com.spring.demospring.dto.UserModel;
import com.spring.demospring.entity.UserEntity;
import com.spring.demospring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseModel createUser(UserModel user) {
		ResponseModel resp = new ResponseModel();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		
		Optional<UserEntity> userFound = userRep.findById(user.getId());
		if (!userFound.isPresent()) {
			userRep.save(userEntity);
			resp.code(0);
			resp.message("User created.");
		} else {
			resp.code(10);
			resp.message("User already exists.");	
		}
		return resp;
	}
	
	@Override
	public ResponseModel deleteUser(Long id) {
		ResponseModel resp = new ResponseModel();
		
		Optional<UserEntity> userFound = userRep.findById(id);
		if (userFound.isPresent()) {
			userRep.deleteById(id);
			resp.code(0);
			resp.message("User deleted.");
		} else {
			resp.code(10);
			resp.message("User does not exist.");	
		}
		return resp;
	}

	@Override
	public UserModel getUserById(Long id) {
		UserModel user = null;
		Optional<UserEntity> userEntity = userRep.findById(id);

		if (userEntity.isPresent()) {
			user = modelMapper.map(userEntity.get(), UserModel.class);
		}

		return user;
	}

	@Override
	public ResponseModel updateUser(Long id, UserModel user) {
		ResponseModel resp = new ResponseModel();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		
		Optional<UserEntity> userFound = userRep.findById(id);
		if (id != userEntity.getId()) {
			userEntity.setId(id);
		}
		if (userFound.isPresent()) {
			userRep.save(userEntity);
			resp.code(0);
			resp.message("User updated.");
		} else {
			resp.code(10);
			resp.message("User does not exist.");	
		}
		return resp;
	}

}
