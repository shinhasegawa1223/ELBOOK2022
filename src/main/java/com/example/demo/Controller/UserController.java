package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.UserList;
import com.example.demo.Service.UserService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	//アクセス時にユーザーを一覧で取得
	@GetMapping("/info")
	public String findUser(Model model) {
		model.addAttribute("UserList", userService.lists());
		return "userinfo";
	}

	//ユーザーの編集
	@GetMapping("/edit/{user_id}")
	public String userEdit(@PathVariable int user_id, Model model) {
		model.addAttribute("TargetUser", userService.targetuser(user_id));
		return "useredit";
	}

	//ユーザーを作成画面へ移動
	@GetMapping("/createview")
	public String moveCreateView(Model model) {
		return "usercreate";
	}

	//ユーザーを作成処理　
	@PostMapping("/usercreate")
	public String userCreate(@ModelAttribute("createUser") UserList userList) {
		//System.out.println(userList);
		userService.create(userList);
		return "redirect:info";
	}

	//ユーザーの編集反映処理
	@PostMapping("/useredit")
	public String userEdit(@ModelAttribute("editUser") UserList userList) {
		//System.out.println(userList);
		userService.edit(userList);
		return "redirect:info";
	}

	//ユーザーの削除処理
	@PostMapping("/delete")
	public String userDelete(@ModelAttribute("deleteUser") UserList userList) {
		//System.out.println(userList);
		userService.delete(userList);
		return "redirect:info";
	}

}
