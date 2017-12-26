package com.my.test.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Secured("ROLE_USER")
    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", "qweqwe");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World222") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

}
