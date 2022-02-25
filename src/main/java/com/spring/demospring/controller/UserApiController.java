package com.spring.demospring.controller;

import javax.annotation.Generated;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demospring.api.UserApi;
import com.spring.demospring.dto.ResponseModel;
import com.spring.demospring.dto.UserModel;
import com.spring.demospring.service.exception.UserException;
import com.spring.demospring.service.user.UserService;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-19T18:02:28.634+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.swaggerDemoSpring.base-path:}")
public class UserApiController implements UserApi {

	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<UserModel> getUserById(Long id) {
		UserModel user = userService.getUserById(id);
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<ResponseModel> createUser(@Valid UserModel user) {
		ResponseModel resp = null;
		resp = userService.createUser(user);
		return new ResponseEntity<ResponseModel>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseModel> deleteUser(Long id) {
		ResponseModel resp = null;
		resp = userService.deleteUser(id);
		return new ResponseEntity<ResponseModel>(resp, HttpStatus.OK);
	}

	@Override

	public ResponseEntity<ResponseModel> updateUser(Long id, @Valid UserModel user) {
		ResponseModel resp = null;
		resp = userService.updateUser(id, user);
		return new ResponseEntity<ResponseModel>(resp, HttpStatus.OK);
	}

}
