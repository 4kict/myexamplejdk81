package com.my.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by SBT-Kiladze-GS on 18.12.2017.
 */
@Controller
public class JspController {


    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", "qweqwe");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World222") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

}
