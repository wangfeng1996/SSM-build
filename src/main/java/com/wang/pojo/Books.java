package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

/**
 * data 是生成get()和set()方法还有toString方法;注解免去了好多手写的代码
 * NoArgsConstructor 是生成一个无参的构造函数，
 * AllArgsContructor 生成一个有参构造函数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int bookID;

    private String bookName;

    private int bookCounts;

    private String detail;

}