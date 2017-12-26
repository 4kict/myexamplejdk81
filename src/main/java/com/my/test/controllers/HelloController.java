package com.my.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by SBT-Kiladze-GS on 22.11.2017.
 */
@Validated
@RestController
public class HelloController {


    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public String getWithName(@Valid @PathVariable @Size(max = 10) String name) {
//        if (bindingResult.hasErrors()) {
//            return bindingResult.toString();
//        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return name + " (" + ((UserDetails) principal).getUsername() + ")";
    }


//    @RequestMapping("/welcome")
//    public String welcome(Model model) {
//        model.addAttribute("message", "Big BRo");
//        return "welcome";
//    }

    /**
     * Обработчик ошибок валидации
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleResourceNotFoundException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append(violation.getMessage() + "\n");
        }
        return strBuilder.toString();
    }

}
