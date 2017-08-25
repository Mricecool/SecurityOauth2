package com.jconfig.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局配置
 * Created by mr on 2017/8/21.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    //全局异常处理，拦截所有Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception ex, WebRequest request){
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("errorMsg",ex.getMessage());
        return modelAndView;
    }

    //全局参数
    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("msg","全局信息");
    }

    //忽略request中的id
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

}
