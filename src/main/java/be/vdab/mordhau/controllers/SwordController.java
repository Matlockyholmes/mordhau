package be.vdab.mordhau.controllers;

import be.vdab.mordhau.Domain.Sword;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
@RequestMapping("swords")
public class SwordController {
    private Sword[] swordArray = {
            new Sword(1,"shortsword", BigDecimal.valueOf(7.50),false),
            new Sword(2,"greatsword",BigDecimal.valueOf(18.30),true),
            new Sword(3,"armingsword",BigDecimal.valueOf(12.10),false),
            new Sword(4,"zweihander",BigDecimal.valueOf(27.10),true)
    };
    @GetMapping
    public ModelAndView swordBringer(){
        return new ModelAndView("swords","swords",swordArray);
    }
    @GetMapping("{id}")
    public ModelAndView detailBringer(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("sword");
        Arrays.stream(swordArray).filter(sword -> sword.getId() == id).findFirst().
                ifPresent(sword -> modelAndView.addObject("sword",sword));
        return modelAndView;
    }

}
