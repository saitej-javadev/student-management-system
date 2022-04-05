package com.saitej.sms.studentmanagementsystem.services;

import com.saitej.sms.studentmanagementsystem.entities.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudents();
    public Student saveStudent(Student student);
    public Student getStudentById(Long id);
    public Student updateStudent(Student student);
    public void deleteStudentById(Long id);
}
