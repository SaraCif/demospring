package com.spring.demospring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.spring.demospring.dto.UserModel;
import com.spring.demospring.entity.UserEntity;
import com.spring.demospring.repository.UserRepository;

@Service
public class SearchUserServiceImpl implements SearchUserService {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserModel> searchUsers(String name, String surname) {
		List<UserEntity> usersEntity = new ArrayList<UserEntity>();
		List<UserModel> dtos = new ArrayList<>();

		UserEntity userExample = new UserEntity();
		userExample.setName(name);
		userExample.setSurname(surname);
		/*
		 * ExampleMatcher per escludere nella where gli input null e renderli case insensitive
		 */
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase();
		Example<UserEntity> exampleQuery = Example.of(userExample, matcher);
		usersEntity = userRep.findAll(exampleQuery);

		if (!usersEntity.isEmpty()) {
			dtos = usersEntity.stream().map(user -> modelMapper.map(user, UserModel.class))
					.collect(Collectors.toList());
		}

		return dtos;
	}

}
