package com.aktansanhal.springboot.thymeleaf.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aktansanhal.springboot.thymeleaf.entity.Employee;
import com.aktansanhal.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class DemoController {
	
	private EmployeeService employeeService;
	
	
	
	
	@Autowired
	public DemoController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}





	@GetMapping("/list")
	public String showPage(Model model) {
			
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		
		return "index";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String getFormForAdd(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id,Model model) {
		
		Employee employee = employeeService.findById(id);
		
		model.addAttribute(employee);
		
		return "employee-form";
		
		
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
}
