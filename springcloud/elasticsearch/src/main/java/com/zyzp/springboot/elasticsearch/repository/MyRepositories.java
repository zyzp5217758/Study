package com.zyzp.springboot.elasticsearch.repository;

import com.zyzp.springboot.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyRepositories extends ElasticsearchRepository<Book,String> {

    public Book getBookByBookId(String bookId);

    public List<Book> getBooksByAuthorIsLike(String author);
}
