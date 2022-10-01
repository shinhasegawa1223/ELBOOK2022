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

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	//アクセス時にユーザーを一覧で取得
	@GetMapping("/list")
	//Modelのクラスをインスタンス化 Model model
	public String findUser(Model model) {
		//コントローラからビューに値を渡す
		//modelクラスのaddAttributeメソッドを使用する
		model.addAttribute("UserList", userService.findUser());
		return "userlist";
	}

	//ユーザーの編集
	@GetMapping("/editview/{user_id}")
	public String moveEditView(@PathVariable int user_id, Model model) {
		model.addAttribute("TargetUser", userService.targetUser(user_id));
		return "useredit";
	}
	@GetMapping("/delete/{user_id}")
	public String deleteUser(@PathVariable int user_id, Model model) {
		userService.deleteUser(user_id);
		return "redirect:/user/list";
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
		userService.userCreate(userList);
		return "redirect:/user/list";
	}

	//ユーザーの編集反映処理
	@PostMapping("/useredit")
	public String userEdit(@ModelAttribute("editUser") UserList userList) {
		//System.out.println(userList);
		userService.userEdit(userList);
		return "redirect:/user/list";
	}
}
