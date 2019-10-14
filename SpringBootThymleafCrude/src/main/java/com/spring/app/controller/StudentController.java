package com.spring.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.app.model.Student;
import com.spring.app.repository.StudentRepository;

@Controller
@RequestMapping(value="/student" ,method = RequestMethod.POST,headers="Accept=application/x-www-form-urlencoded")
public class StudentController {
	
    public final StudentRepository studentRepository; 
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    
     @Autowired 
    public StudentController(StudentRepository studentRepository){
    	this.studentRepository=studentRepository;
    }
     
     @GetMapping(value="/signup")
    public String ShowSignUpForm(Student student) {
    	return "add-student";
    }
     @GetMapping(value="/list")
     public String showUpdateForm(Model model) {
    	 model.addAttribute("student",studentRepository.findAll());
    	 return "index";
     }
     
     @PostMapping(value="/add")
     public String addStudent(Student student/*,BindingResult result,Model model*/) {
    	// if (result.hasErrors()) {
    		// logger.info("Validation errors while submitting form.");
    		 //return "add-student";
    	// }
    	 studentRepository.save(student);
    	 return "redirect:list";
     }
     @GetMapping(value = "/edit/{id}")
     public String showUpdateForm(@PathVariable ("id") long id,Model model) {
    	 Student student = studentRepository.findOne(id);
    	 model.addAttribute("student",student);
    	 return "update-student";
     }
     @GetMapping(value = "/update/{id}")
     public String updateStudent(@PathVariable("id") long id,Student student,Model model) {
    	 studentRepository.save(student);
    	 model.addAttribute("student",studentRepository.findAll());
    	 return "index";
     }
     
     
     
     @GetMapping(value = "/delete/{id}")
     public String deleteStudent(@PathVariable("id") long id , Model model) {
    	 Student stuid = studentRepository.findOne(id);
    	 studentRepository.delete(stuid);
    	 model.addAttribute("student",studentRepository.findAll());
    	 return "index";
     }
}
