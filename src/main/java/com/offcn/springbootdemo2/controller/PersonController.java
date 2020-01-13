package com.offcn.springbootdemo2.controller;

import com.offcn.springbootdemo2.bean.Person;
import com.offcn.springbootdemo2.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("addPerson")
    public void addPerson(@RequestBody Person person) {
        personRepository.save(person);

    }

    @GetMapping("getAllPerson")
    public List<Person> getPerson(){
        return  personRepository.findAll();
    }
     @DeleteMapping("deletePerson")
     public void deletePerson(@RequestParam Long id){
        personRepository.deleteById(id);
     }

     @PutMapping("updatePerson")
    public  void updatePerson(@RequestBody Person person){
          personRepository.saveAndFlush(person);
     }
}
