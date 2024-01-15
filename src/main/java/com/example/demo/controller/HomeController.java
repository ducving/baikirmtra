package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/city")
public class HomeController {
    @Autowired
    ICityService iCityService;
    @GetMapping("")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        List<City> list = iCityService.findAll();
        model.addObject("listCity", list);
        return model;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView= new ModelAndView("create");
            modelAndView.addObject("listErr",bindingResult.getAllErrors());
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/city");
        iCityService.save(city);
        return modelAndView;
    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("edit",iCityService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@Validated  City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView= new ModelAndView("create");
            modelAndView.addObject("listErr",bindingResult.getAllErrors());
            return modelAndView;
        }
        ModelAndView modelAndView=new ModelAndView("redirect:/city");
        iCityService.save(new City(city.getId(),city.getName(),city.getNation(),city.getAcreage(),city.getPopulation(),city.getGDP(),city.getDescribes()));
        List<City> cities = iCityService.findAll();
        modelAndView.addObject("edit",cities);
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Integer id){
        ModelAndView modelAndView=new ModelAndView("redirect:/city");
        iCityService.delete(id);
        return modelAndView;
    }
}
