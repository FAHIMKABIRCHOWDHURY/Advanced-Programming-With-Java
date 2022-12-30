package com.controller;
import com.domain.History;
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
@RequestMapping("/histories")
public class HistoryController {
    private HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/seeHistories")
    public ResponseEntity<List<History>> getAllHistories() {
        List<History> historiess = HistoryService.getAll();
        return ResponseEntity.ok().body(historiess);
    }

    @RequestMapping("/submitHistory")
    public String submit(@Valid @ModelAttribute("history") History Huser,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "noUser";
        }
        else {
            HistoryService.insert(Huser);
            return "ShowTax";
        }


    }

    @RequestMapping("/updateHistory")
    public String submit(@Valid @ModelAttribute("history") History Huser,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "noUser";
        }
        else {
            HistoryService.update(Huser);
            return "Admin";
        }


    }
    @RequestMapping("/deleteHistory")
    public void delete((@RequestParam("userId") int userId) throws SQLException {
        HistoryService.delete(userId);

    }
}
