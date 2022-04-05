package com.saitej.sms.studentmanagementsystem.controllers;

import com.saitej.sms.studentmanagementsystem.entities.Student;
import com.saitej.sms.studentmanagementsystem.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String indexController(){
        return "index";
    }

    @GetMapping("/students")
    public String getStudent(Model model){
        model.addAttribute("students",studentService.getStudents());
        return "student";
    }
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id ,
                                @ModelAttribute("student")
                                        Student student  ,
                                        Model model){

        Student savedStudent = studentService.getStudentById(id);
        savedStudent.setId(id);
        savedStudent.setFirstName(student.getFirstName());
        savedStudent.setLastName(student.getLastName());
        savedStudent.setEmail(student.getEmail());
        studentService.updateStudent(savedStudent);

        return  "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
