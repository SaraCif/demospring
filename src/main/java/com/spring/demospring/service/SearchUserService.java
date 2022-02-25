package com.spring.demospring.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.demospring.dto.UserModel;

@Component
@Service
public interface SearchUserService {

	List<UserModel> searchUsers(String name, String surname);
}
