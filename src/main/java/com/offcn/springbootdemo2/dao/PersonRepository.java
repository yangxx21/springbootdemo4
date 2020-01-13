package com.offcn.springbootdemo2.dao;

import com.offcn.springbootdemo2.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository <Person,Long>{

    //查询指定用户姓名的用户
    public Person findByNameIs(String name);
    //查询指定用户姓名和密码都相同的用户
    public Person findByNameIsAndPassword(String name,String password);
    //查询包含指定名字的用户
    public List<Person> findByNameContaining(String name);

    //查询制定用户姓名的用户
    @Query("select p from Person p where p.name=:name")
    public Person getPerson(@Param("name") String name);
    //用户登录验证
    @Query("select p from Person p where p.name=?1 and p.password=?2")
    public  Person login(@Param("name") String name,@Param("password") String password);
    //模糊查询用户名里面包含制定字符
    @Query("select  p from Person p where p.name like %:name%")
    public  List<Person> getNamesLike(@Param("name") String name);
    //查询密码位数是5位数的全部用户，使用mysql原始sql语句进行查询
    @Query(value = "select  * from person where length(password)=5",nativeQuery=true)
    public  List<Person> getPasswordisFive();
}
