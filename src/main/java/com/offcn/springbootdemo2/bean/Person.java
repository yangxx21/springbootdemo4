package com.offcn.springbootdemo2.bean;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private  Long id;

    @Column(name="name",nullable = true,length=20)
    private String name;

    @Column(name="age",nullable=true,length = 20)
     private int age;

    @Column(name="password",nullable = true,length = 20)
    private String password;

}
