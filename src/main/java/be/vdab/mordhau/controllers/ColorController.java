package be.vdab.mordhau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("colors")
class ColorController {
    @GetMapping
    public ModelAndView showPage(@CookieValue(name = "color", required = false) String color) {
        return new ModelAndView("colors","color",color);
    }
    @GetMapping("{color}")
    public ModelAndView choseColor(@PathVariable String color, HttpServletResponse response){
        Cookie cookie = new Cookie("color",color);
        cookie.setMaxAge(31_536_000);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("colors");
    }
}
