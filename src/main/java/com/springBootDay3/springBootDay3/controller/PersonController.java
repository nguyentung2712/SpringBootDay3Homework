package com.springBootDay3.springBootDay3.controller;

import com.springBootDay3.springBootDay3.dao.PersonDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("persons",personDAO.getAll());
        return "index";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("persons",personDAO.getAll());
        return "getAll";
    }

    @GetMapping("/sortPeopleByFullName")
    public String sortPeopleByFullName(Model model){
        model.addAttribute("persons",personDAO.sortPeopleByFullName());
        return "sortPeopleByFullName";
    }

    @GetMapping("/getSortedJobs")
    public String getSortedJobs(Model model){
        model.addAttribute("jobs",personDAO.getSortedJobs());
        return "getSortedJobs";
    }

    @GetMapping("/getSortedCities")
    public String getSortedCities(Model model){
        model.addAttribute("cities",personDAO.getSortedCities());
        return "getSortedCities";
    }

    @GetMapping("/groupPeopleByCity")
    public String groupPeopleByCity(Model model){
        model.addAttribute("groupPerson",personDAO.groupPeopleByCity());
        return "groupPeopleByCity";
    }

    @GetMapping("/groupJobByCount")
    public String groupJobByCount(Model model){
        model.addAttribute("jobs",personDAO.groupJobByCount());
        return "groupJobByCount";
    }

    @GetMapping("/aboveAverageSalary")
    public String aboveAverageSalary(Model model){
        model.addAttribute("persons",personDAO.aboveAverageSalary());
        return "aboveAverageSalary";
    }

    @GetMapping("/longestName")
    public String longestName(Model model){
        model.addAttribute("person",personDAO.longestName());
        return "longestName";
    }
}
