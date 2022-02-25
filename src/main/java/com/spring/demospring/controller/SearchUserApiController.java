package com.spring.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.spring.demospring.api.ApiUtil;
import com.spring.demospring.api.SearchUserApi;
import com.spring.demospring.dto.UserModel;
import com.spring.demospring.service.SearchUserService;

import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-19T18:02:28.634+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.swaggerDemoSpring.base-path:}")
public class SearchUserApiController implements SearchUserApi {

	@Autowired
	SearchUserService userService;

	@Override
	public ResponseEntity<List<UserModel>> searchUser(String name, String surname) {
		List<UserModel> cc = new ArrayList<UserModel>();
		cc = userService.searchUsers(name, surname);
		return new ResponseEntity<List<UserModel>>(cc, HttpStatus.OK);
	}

}
