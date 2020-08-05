package com.eportal.web;


import com.eportal.vo.CustomerVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;


@Controller
@Slf4j
public class LoginController {
    @GetMapping(value="/")
    public ModelAndView landing() {
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("login", params);
    }

    @GetMapping(value="/login")
    public ModelAndView loginGet() {
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("login", params);
    }

    @PostMapping(value="/login")
    public ModelAndView loginPost(CustomerVO customerVO) {
        log.info("captcha: {}", customerVO);
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("dashboard", params);
    }

    @GetMapping(value="/dashboard")
    public ModelAndView dashboardGet() {
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("dashboard", params);
    }
}
