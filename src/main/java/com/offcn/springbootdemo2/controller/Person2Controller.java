package com.offcn.springbootdemo2.controller;

import com.offcn.springbootdemo2.bean.Person;
import com.offcn.springbootdemo2.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person2")
public class Person2Controller {
  @Autowired
    private PersonRepository personRepository;


  @GetMapping("findByNameIs/{name}")
    public Person findByName(@PathVariable String name){
      return personRepository.findByNameIs(name);
  }

  @GetMapping("findByNameIsAndPassword/{name}/{password}")
    public Person findByNameIsAndPassword(@PathVariable String name,@PathVariable String password){
         return  personRepository.findByNameIsAndPassword(name,password);
  }
 @GetMapping("findByNameContaining/{name}")
    public List<Person> findByNameContaining(@PathVariable String name){
      return  personRepository.findByNameContaining(name);

 }


}
