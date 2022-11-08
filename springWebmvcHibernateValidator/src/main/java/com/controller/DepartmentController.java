package com.controller;

import com.domain.Department;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Department> departments = new ArrayList<>();
        model.addAttribute("departments", departments);
        return "department/list";
    }

    @RequestMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @RequestMapping("/create")
    public String create(@Valid @ModelAttribute("department") Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department/create";
        }
        return "redirect:/departments/list";
    }
}
