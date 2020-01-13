package com.offcn.springbootdemo2.controller;

import com.offcn.springbootdemo2.bean.Person;
import com.offcn.springbootdemo2.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person3")
public class Person3Controller {
    @Autowired
    private PersonRepository personRepository;
    @GetMapping("getPerson/{name}")
    public Person  getPerson(@PathVariable String name){
        return  personRepository.getPerson(name);
    }
    @GetMapping("login/{name}/{password}")
    public Person login(@PathVariable String name,@PathVariable String password){
        return personRepository.login(name,password);
    }
    @GetMapping("getNameLike/{name}")
    public List<Person>  getNameLike(@PathVariable String name){
        return  personRepository.getNamesLike(name);
    }
    @GetMapping("getPasswordisFive")
    public  List<Person> getPasswordisFive(){
        return personRepository.getPasswordisFive();
    }
}
