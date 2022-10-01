package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserList;
import com.example.demo.Mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	//クラス名　インスタンス化
	UserMapper userMapper;

	// リストを作成　returnを使用して戻り値を取得する
	public List<UserList> findUser() {
		//UserMapperクラスのfindUserを使用する　引数は無し
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

	public void userDelete(int user_id) {
		userMapper.userDelete(user_id);
	}

}