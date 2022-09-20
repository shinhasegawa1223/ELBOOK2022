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

	public List<UserList> lists() {
		return userMapper.userlists();
	}

	public List<UserList> targetuser(int user_id) {
		return userMapper.targetuser(user_id);
	}

	public void create(UserList userList) {
		userMapper.create(userList);
	}

	public void edit(UserList userList) {
		userMapper.edit(userList);
	}

	public void delete(UserList userList) {
		userMapper.delete(userList);
	}

}