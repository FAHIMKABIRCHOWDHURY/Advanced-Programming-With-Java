package com.controller;
import com.domain.Category;
import com.domain.History;
import com.service.CategoryService;
import com.service.HistoryService;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/Categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/submitCategory")
    public String submit(@Valid @ModelAttribute("Category") Category category,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "noUser";
        }
        else {
            CategoryService.insert(category);
            return "confirmationUser";
        }
    }

    @RequestMapping("/updateCategory")
    public String Update(@Valid @ModelAttribute("Category") Category category,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "noUser";
        }
        else {
            categoryService.update(category);
            return "Done";
        }


    }

    @RequestMapping("/deleteCategory")
    public void delete((@RequestParam("cId") int cId) throws SQLException {
        categoryService.delete(cId);

    }
    @GetMapping("/seeCategories")
    public ResponseEntity<List<Category>> getAllategories() {
        List<Category> categories = CategoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

}
