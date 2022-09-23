package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserList;
import com.example.demo.Mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public List<UserList> findUser() {
		return userMapper.findUser();
	}

	public List<UserList> targetUser(int user_id) {
		return userMapper.targetUser(user_id);
	}

	public void userCreate(UserList userList) {
		userMapper.userCreate(userList);
	}

	public void userEdit(UserList userList) {
		userMapper.userEdit(userList);
	}

	public void userDelete(UserList userList) {
		userMapper.userDelete(userList);
	}

}