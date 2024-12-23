package raisetech.StudentManagement;
//平田君とgitの練習中　その２

//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

//import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.*;

//import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

@Autowired
private static StudentRepository repository;

public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

    @GetMapping("/studentList")
    public List<Student> getStudentList () {
        return repository.search();
    }
}

}



