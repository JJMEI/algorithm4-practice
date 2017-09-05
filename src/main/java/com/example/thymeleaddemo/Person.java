package com.example.thymeleaddemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by meijunjie on 2017/9/3.
 */

@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Integer age;


}
