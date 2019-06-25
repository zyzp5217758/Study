package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Students implements Serializable {

    private String sid;
    private String sname;
    private Integer age;
    private Double score;
}
