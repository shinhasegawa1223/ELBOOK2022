package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.BookList;

@Mapper
public interface BookMapper {

	List<BookList> findBook();

	List<BookList> targetBook(int book_id);

	void bookCreate(BookList bookList);

	void bookEdit(BookList bookList);

	void bookDelete(int book_id);

}
