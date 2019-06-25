package com.zyzp.springboot.cache.service;

import com.zyzp.springboot.cache.entity.Book;
import com.zyzp.springboot.cache.mapper.BookMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Cacheable(key = "'book_'+#bookId",cacheNames = "book")
    public Book getBookById(String bookId){
        Book book = bookMapper.getBookById(bookId);
        rabbitTemplate.convertAndSend("zyzp.news",book);
        return book;
    }

    @Cacheable(key = "book_all",cacheNames = "book")
    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }

    @Cacheable(key = "'book_'+#bookName",cacheNames = "book")
    public List<Book> getBookByName(String bookName){
        return bookMapper.getBookByName(bookName);
    }
    @CachePut(key = "'book_'+#book.bookId",cacheNames = "book")
    public Book updateBook(Book book){
        return bookMapper.updateBook(book);
    }
    @CacheEvict(key = "'book_'+#book.bookId",cacheNames = "book")
    public boolean delBook(String bookId){
        return bookMapper.delBook(bookId);
    }
}
