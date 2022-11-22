package com.controller;

import com.domain.Leaves;
import com.service.LeaveApplicationService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/leaveApplicaiton")

public class LeaveApplicationController {
    private LeaveApplicationService leaveApplicationService;

    public LeaveApplicationController(LeaveApplicationService las) {
        this.leaveApplicationService = las;
    }

    @RequestMapping("/show")
    public String show(Model model) {
        Leaves leave1 = new Leaves();
        model.addAttribute("leave1", leave1);
        return "registration";
    }
    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("leaves") Leaves leaves, BindingResult bindingResult) throws SQLException {

            leaveApplicationService.insert(leaves);
            return "confirmation";
        }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
