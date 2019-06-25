package com.zyzp.springboot.cache.mapper;

import com.zyzp.springboot.cache.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    public Book getBookById(String bookId);

    public List<Book> getAllBooks();

    public List<Book> getBookByName(String bookName);

    public Book updateBook(Book book);

    public boolean delBook(String bookId);
}
