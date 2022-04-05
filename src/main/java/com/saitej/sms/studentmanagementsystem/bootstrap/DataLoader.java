package com.saitej.sms.studentmanagementsystem.bootstrap;

import com.saitej.sms.studentmanagementsystem.entities.Student;
import com.saitej.sms.studentmanagementsystem.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public DataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("Virat","Kohli", "virat@gmail.com");
        Student student2 = new Student("Sachin","Tendulkar", "tendulkar@gmail.com");

        studentRepository.save(student1);
        studentRepository.save(student2);

        System.out.println("Student Data Loaded.............");

    }
}
