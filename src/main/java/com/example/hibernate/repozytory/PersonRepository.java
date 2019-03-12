package com.example.hibernate.repozytory;

import com.example.hibernate.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT p from Person p ORDER BY p.id")
    List<Person> findAllSortById();

    @Query("SELECT p FROM Person p WHERE p.age=?1")
    List<Person> findByAge(Integer age);

    @Query("SELECT p FROM Person p WHERE p.name=?1 OR p.age=?2")
    List<Person> findByNameOrAge(String name, Integer age);

}
