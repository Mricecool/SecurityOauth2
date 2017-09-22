package com.jconfig.controller;

import com.jconfig.dao.UsersDao;
import com.jconfig.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mr on 2017/8/21.
 */
@Controller
@RequestMapping("/")
public class SpringController {

    @Autowired
    UsersDao usersDao;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value ="error",required = false) boolean error, Model model){
        if(error){
            model.addAttribute("error","You have entered an invalid username or password!");
        }else{
            model.addAttribute("error","");
        }
        return "login";
    }

    @RequestMapping("/e")
    public String error(@ModelAttribute("msg") String msg) {
        throw new RuntimeException(msg + ":异常");
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public String auth(String code,String state,Model model) {
        model.addAttribute("code",code);
        return "code";
    }

    @Scheduled(fixedRate = 5000)
    public void exeTask() {
        System.out.println("执行任务");
    }

}
