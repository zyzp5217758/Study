package com.zyzp.springboot.cache.controller;

import com.zyzp.springboot.cache.entity.Book;
import com.zyzp.springboot.cache.service.BookService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBookById/{bookId}")
    public Book getBookById(@PathVariable("bookId") String bookId){
        Book book =  bookService.getBookById(bookId);
        getMessage();
        return book;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookByName/{bookName}")
    public List<Book> getBookByName(@PathVariable("bookName") String bookName){
        return bookService.getBookByName(bookName);
    }

    @PutMapping("/updateBook")
    public Book updateBook(Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("delBook/{bookId}")
    public boolean delBook(@PathVariable("bookId") String bookId){
        return bookService.delBook(bookId);
    }

    @Async
    public void getMessage(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("getMessage已经执行完了");
    }
}
