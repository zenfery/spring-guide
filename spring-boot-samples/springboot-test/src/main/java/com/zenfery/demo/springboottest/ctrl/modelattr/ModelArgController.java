package com.zenfery.demo.springboottest.ctrl.modelattr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zenfery.demo.springboottest.model.attr.ModelAttr;
import com.zenfery.demo.springboottest.model.attr.ModelAttr1;

@Controller
public class ModelArgController {

    @ModelAttribute
    public void preModelHandle(Model model, HttpSession session) {
        model.addAttribute("preModelAttr", "preModelAttr value from *preModelHandle()* ");

        ModelAttr1 modelAttr1 = new ModelAttr1();
        modelAttr1.setRequestParam("requestParam value from *preModelHandle()* ");
        modelAttr1.setPreAtrr("preAttr value from *preModelHandle()* ");
        model.addAttribute("modelAttr1", modelAttr1);

        model.addAttribute("preModelAttrList", new ArrayList<String>());

        session.setAttribute("sessionAttr", "sessionAttr value from *preModelHandle()* ");
    }

    @RequestMapping(value = "/model/modelattr/{pathVar}")
    public String modelAttr(Model model, @RequestParam String requestParam, ModelAttr ma,
        @ModelAttribute ModelAttr1 ma1, @ModelAttribute(value = "preModelAttr") String preModelAttr,
        @ModelAttribute(value = "preModelAttrList") List<String> preModelAttrList,
        @SessionAttribute("sessionAttr") String sessionAttr) {
        model.addAttribute("normalAttr", "I am normalAttr");
        return "model/model-attr";
    }

    @ModelAttribute("attrReturn")
    @RequestMapping(value = "/model/model-attr-returnvalue")
    public String modelAttrReturnValue(Model model) {
        model.addAttribute("normalAttr", "I am normalAttr");
        return "Model Attr Returnvalue";
    }
}
