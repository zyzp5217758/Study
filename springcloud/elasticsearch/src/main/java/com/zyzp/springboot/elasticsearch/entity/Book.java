package com.zyzp.springboot.elasticsearch.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Document(indexName = "cache",type = "book")
public class Book implements Serializable {
    @Id
    private String bookId;
    private String bookName;
    private String author;
    private Double price;
}
