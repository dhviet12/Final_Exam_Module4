package com.final_exam.module4.controller;


import com.final_exam.module4.model.City;
import com.final_exam.module4.model.National;
import com.final_exam.module4.service.CityService;
import com.final_exam.module4.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    NationalService nationalService;

    @ModelAttribute("listNational")
    public List<National> nationalList() {
        return nationalService.findAllNational();
    }

    @GetMapping()
    public ModelAndView showAllCity(@PageableDefault(size = 5) Pageable pageable) {
        return new ModelAndView("list", "cities", cityService.findAllCity(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCity() {
        return new ModelAndView("create", "city", new City());
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("create");
        }

        cityService.save(city);
        return new ModelAndView("redirect:/city");
    }


    @GetMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id) {
        City city = cityService.findById(id);
        cityService.delete(city);
        return new ModelAndView("redirect:/city");
    }

    @GetMapping("edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        City editCity = cityService.findById(id);
        return new ModelAndView("edit", "city", editCity);
    }

    @PostMapping("edit/{id}")
    public ModelAndView editCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("edit");
        }
        cityService.save(city);
        return new ModelAndView("redirect:/city");
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        City detailCity = cityService.findById(id);
        return new ModelAndView("detail", "city", detailCity);
    }


}
