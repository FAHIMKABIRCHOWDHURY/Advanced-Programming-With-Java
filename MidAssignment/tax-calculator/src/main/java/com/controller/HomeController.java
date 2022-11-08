package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.domain.taxCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller

public class HomeController {
    @RequestMapping("/calculate")
    public String Calculate(){return "calculate";}
    @RequestMapping("/TaxCalculate")
    public ModelAndView taxCount(@RequestParam("Type") String Type, @RequestParam("Age") String Age, @RequestParam("Min") int Min, @RequestParam("NumberOfMonth") int NumberOfMonth, @RequestParam("NumberOfFestivals") int NumberOfFestivals, @RequestParam("AllowableTotalInvestment") int AllowableTotalInvestment, @RequestParam("BasicSalary") int BasicSalary, @RequestParam("Bonus") int Bonus, @RequestParam("LivingAllowence") int LivingAllowence, @RequestParam("ConveyanceAllowence") int ConveyanceAllowence, @RequestParam("OT") int OT) {
        ModelAndView mv = new ModelAndView();

        int taxableAmount = 300000;
        if (Type.equals("Female") || Age.equals("Above-65")) {
            taxableAmount = 350000;
        } else if (Type.equals("Specially-abled")) {
            taxableAmount = 450000;
        } else if (Type.equals("Freedom-Fighter")) {
            taxableAmount = 475000;
        }
        int TaxFromBasicSalary = (BasicSalary - taxableAmount);
        int TaxFromBonus = (Bonus * NumberOfFestivals);
        if (TaxFromBonus > (BasicSalary / 2)) {
            TaxFromBonus = (BasicSalary / 2);
        }

        int TaxFromLivingAllowence =(LivingAllowence);
         int TaxFromConvyance=  (ConveyanceAllowence - 30000);
        int TaxFromOT = (OT);
        int TaxFromAllowableTotalInvestment = (AllowableTotalInvestment);
        int newTotalTaxableAmount = TaxFromBasicSalary + TaxFromBonus + TaxFromLivingAllowence + TaxFromOT+TaxFromAllowableTotalInvestment+LivingAllowence;
        newTotalTaxableAmount=java.lang.Math.abs(newTotalTaxableAmount);
        double taxs=0;
        if(newTotalTaxableAmount<300000) {
            taxs = 0;

        } else if (newTotalTaxableAmount>300000 && newTotalTaxableAmount<400000) {
            taxs= (newTotalTaxableAmount*.005);

        } else if (newTotalTaxableAmount>400000 && newTotalTaxableAmount<700000) {
            taxs= (newTotalTaxableAmount*.0010);
        }
        else if (newTotalTaxableAmount>700000 && newTotalTaxableAmount<1100000) {
            taxs= (newTotalTaxableAmount*.0015);
        }
        else if (newTotalTaxableAmount>1100000 && newTotalTaxableAmount<1600000) {
            taxs= (newTotalTaxableAmount*.0020);
        }
        else if (newTotalTaxableAmount>1600000) {
            taxs= (newTotalTaxableAmount*.0025);
        }
        mv.addObject("newTotalTaxableAmount", newTotalTaxableAmount);
mv.addObject("Taxs",taxs);
        mv.setViewName("/ShowTax");
        return mv;
    }


}
