package com.eportal.web;


import com.eportal.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller
@Slf4j
public class LoginController {
    @ResponseBody
    @GetMapping(value="/login")
    public ModelAndView loginGet() {
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("login", params);
    }

    @PostMapping(value="/login")
    public ModelAndView loginPost(User user, HttpServletRequest request) {
        log.info("user: {}", user);

        HashMap<String, Object> params = new HashMap<String, Object>();
        if (user.getCaptcha().equals(request.getSession().getAttribute("captcha"))) {
            return new ModelAndView("redirect:dashboard", params);
        }
        return new ModelAndView("login", params);
    }

    @GetMapping(value="/dashboard")
    public ModelAndView dashboardGet() {
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("dashboard", params);
    }
}
