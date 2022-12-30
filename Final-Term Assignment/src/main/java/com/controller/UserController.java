package com.controller;
import com.domain.History;
import com.service.HistoryService;
import com.domain.User;
import com.service.UserService;
import com.service.CategoryService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/users")

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/calculate")
    public String Calculate(){return "calculate";}
    @RequestMapping("/TaxCalculate")
    public ModelAndView taxCount(@RequestParam("userId") int userId, @RequestParam("Type") String Type, @RequestParam("Age") String Age, @RequestParam("Min") int Min, @RequestParam("NumberOfMonth") int NumberOfMonth, @RequestParam("NumberOfFestivals") int NumberOfFestivals, @RequestParam("AllowableTotalInvestment") int AllowableTotalInvestment, @RequestParam("BasicSalary") int BasicSalary, @RequestParam("Bonus") int Bonus, @RequestParam("LivingAllowence") int LivingAllowence, @RequestParam("ConveyanceAllowence") int ConveyanceAllowence, @RequestParam("OT") int OT) {
        ModelAndView mv = new ModelAndView();
        float taxableAmount =CategoryService.getPercentage(Type);

        float TaxFromBasicSalary = (BasicSalary - taxableAmount);
        int TaxFromBonus = (Bonus * NumberOfFestivals);
        if (TaxFromBonus > (BasicSalary / 2)) {
            TaxFromBonus = BasicSalary / 2;
        }

        int TaxFromLivingAllowence =(LivingAllowence);
        int TaxFromConvyance=  (ConveyanceAllowence - 30000);
        int TaxFromOT = (OT);
        int TaxFromAllowableTotalInvestment = (AllowableTotalInvestment);
        float newTotalTaxableAmount = TaxFromBasicSalary + TaxFromBonus + TaxFromLivingAllowence + TaxFromOT+TaxFromAllowableTotalInvestment+LivingAllowence;
        newTotalTaxableAmount=java.lang.Math.abs(newTotalTaxableAmount);
        double taxs=0;
        if(newTotalTaxableAmount<300000) {
            taxs = 0;

        } else if (newTotalTaxableAmount>300000 && newTotalTaxableAmount<400000) {
            taxs= (newTotalTaxableAmount*.5);

        } else if (newTotalTaxableAmount>400000 && newTotalTaxableAmount<700000) {
            taxs= (newTotalTaxableAmount*.10);
        }
        else if (newTotalTaxableAmount>700000 && newTotalTaxableAmount<1100000) {
            taxs= (newTotalTaxableAmount*.15);
        }
        else if (newTotalTaxableAmount>1100000 && newTotalTaxableAmount<1600000) {
            taxs= (newTotalTaxableAmount*.20);
        }
        else if (newTotalTaxableAmount>1600000) {
            taxs= (newTotalTaxableAmount*.25);
        }
        mv.addObject("newTotalTaxableAmount", newTotalTaxableAmount);
        mv.addObject("taxs",taxs);
        mv.setViewName("submitHistory");
        mv.setViewName("/ShowTax");
        return mv;
    }

    @RequestMapping("/UserRegistration")
    public String userRegistration(){return "UserRegistration";}

    @RequestMapping("/showUser")
    public String show(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "UserRegistration";
    }
    @GetMapping("/seeUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = UserService.getAll();
        return ResponseEntity.ok().body(users);
    }
    @RequestMapping("/submitUser")
    public String submit(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "noUser";
        }
        else {
            userService.insert(user);
            return "confirmationUser";
        }
    }

    @RequestMapping("/updateUser")
    public String Update(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "noUser";
        }
        else {
            userService.update(user);
            return "Done";
        }


    }

    @RequestMapping("/deleteUser")
    public void delete((@RequestParam("userId") int userId) throws SQLException {
        UserService.delete(userId);

    }

    @RequestMapping("/loginUser")
    public ModelAndView login(@Valid @ModelAttribute("user") User user,@RequestParam("email") String email, @RequestParam("pass") String pass,
                         BindingResult bindingResult) throws SQLException {

        ModelAndView mv = new ModelAndView();
        User user1 = UserService.login(email,pass);
        if (bindingResult.hasErrors() || (user1 == Null)) {

            mv.setViewName("/noUser");
        } else {
            if (user.getType() == "normal") {
                ;
                mv.setViewName("/calculate");
            } else if (user.getType() == "Admin") {

                mv.setViewName("/Admin");
            }


            mv.addObject("id", user.getId());


        }


        return mv;
    }



    }
