package com.eportal.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller
@Slf4j
public class CaptchaDemoController {
    @GetMapping(value="/captcha-demo")
    public ModelAndView captchaDemoGet() {
        HashMap<String, Object> params = new HashMap<String, Object>();

        return new ModelAndView("captcha-demo", params);
    }

    @PostMapping(value="/captcha-demo")
    public ModelAndView captchaDemoPost(String captcha, HttpServletRequest request) {
        log.info("captcha: {}", captcha);

        HashMap<String, Object> params = new HashMap<String, Object>();
        if (captcha.equals(request.getSession().getAttribute("captcha"))) {
            return new ModelAndView("redirect:dashboard", params);
        } else {
            params.put("errorMessage", "Captcha is not correct");
        }
        return new ModelAndView("captcha-demo", params);
    }
}
