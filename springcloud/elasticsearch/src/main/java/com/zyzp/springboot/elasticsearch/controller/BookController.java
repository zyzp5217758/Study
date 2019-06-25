package com.zyzp.springboot.elasticsearch.controller;

import com.zyzp.springboot.elasticsearch.entity.Book;
import com.zyzp.springboot.elasticsearch.repository.MyRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private MyRepositories myRepository;

    @GetMapping("/getBookByBookId/{bookId}")
    public Book getBookByBookId(@PathVariable("bookId")String bookId){
        return myRepository.getBookByBookId(bookId);
    }

    @GetMapping("/getBooksByAuthorIsLike/{bookName}")
    public List<Book> getBooksByAuthorIsLike(@PathVariable("bookName")String bookName){
        return myRepository.getBooksByAuthorIsLike(bookName);
    }

}
