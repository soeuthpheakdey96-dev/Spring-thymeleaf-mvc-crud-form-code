package com.dev.spring.mvc.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.dev.spring.mvc.thymeleafdemo.model.Employee;
import com.dev.spring.mvc.thymeleafdemo.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Value("${education}")
    private List<String> educationOptions;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);
    }

    @GetMapping("/list-employee")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employee", employees);

        return "employee/list-employee";
    }

    @GetMapping("/showMyLoginPage")
    public String showLoginPage() {
        return "employee/login";
    }

    @GetMapping("/showformforadd")
    public String showFormForAdd(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("Educationlist", educationOptions);

        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee emp,
                               BindingResult result) {

        if (result.hasErrors()) {
            return "employee/employee-form";
        }

        employeeService.save(emp);
        return "redirect:/employee/list-employee";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
                                     Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("Educationlist", educationOptions);

        return "employee/employee-form";
    }

    @GetMapping("/deleteshowform")
    public String deleteEmployee(@RequestParam("employeeId") int id) {

        employeeService.deleteById(id);

        return "redirect:/employee/list-employee";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword,
                         Model model) {

        List<Employee> list = (keyword == null)
                ? employeeService.findAll()
                : employeeService.search(keyword);

        model.addAttribute("employee", list);
        model.addAttribute("keyword", keyword);

        return "employee/list-employee";
    }
    
	@GetMapping("/access-denied")
	public String acess() {
		return "employee/access-denied";
	}
	@GetMapping("logout")
	public String logout() {
		
		return "employee/logout";
		
	}
}