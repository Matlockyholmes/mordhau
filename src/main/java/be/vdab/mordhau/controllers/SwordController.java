package be.vdab.mordhau.controllers;

import be.vdab.mordhau.Domain.Sword;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping("swords")
public class SwordController {
    private Sword[] swordArray = {
            new Sword(1,"Short sword", BigDecimal.valueOf(7.50),false),
            new Sword(2,"Greatsword",BigDecimal.valueOf(18.30),true),
            new Sword(3,"Arming sword",BigDecimal.valueOf(12.10),false),
            new Sword(4,"Zweihander",BigDecimal.valueOf(27.10),true)
    };
    @GetMapping
    public ModelAndView swordBringer(){
        return new ModelAndView("swords","swords",swordArray);
    }
}
