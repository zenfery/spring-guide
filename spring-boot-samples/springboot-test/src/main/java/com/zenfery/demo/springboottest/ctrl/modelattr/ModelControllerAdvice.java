package com.zenfery.demo.springboottest.ctrl.modelattr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ModelControllerAdvice {

    @ModelAttribute
    public void preAdviceModelHandle(Model model){
        model.addAttribute("preAdviceModelAttr", "Pre Advice Model Atrr Value");
    }
}
