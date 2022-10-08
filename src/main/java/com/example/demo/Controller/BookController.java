package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.BookList;
import com.example.demo.Service.BookService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	//アクセス時にユーザーを一覧で取得
	@GetMapping("/info")
	public String findBook(Model model) {
		model.addAttribute("BookList", bookService.findBook());
		return "bookinfo";
	}

	//ユーザーの編集
	@GetMapping("/editview/{book_id}")
	public String moveEditView(@PathVariable int book_id, Model model) {
		model.addAttribute("TargetBook", bookService.targetBook(book_id));
		return "bookedit";
	}

	//ユーザーを作成画面へ移動
	@GetMapping("/createview")
	public String moveCreateView(Model model) {
		return "bookcreate";
	}

	//ユーザーを作成処理
	@PostMapping("/bookcreate")
	public String bookCreate(@ModelAttribute("createBook") BookList bookList) {
		//System.out.println(bookList);
		bookService.bookCreate(bookList);
		return "redirect:/book/info";
	}

	//ユーザーの編集反映処理
	@PostMapping("/bookedit")
	public String bookEdit(@ModelAttribute("editBook") BookList bookList) {
		System.out.println(bookList);
		bookService.bookEdit(bookList);
		return "redirect:/book/info";
	}

	//ユーザーの削除処理
	@GetMapping("/bookdelete/{book_id}")
	public String bookDelete(@PathVariable int book_id) {
		//System.out.println(book_id);
		bookService.bookDelete(book_id);
		return "redirect:/book/info";
	}

}
