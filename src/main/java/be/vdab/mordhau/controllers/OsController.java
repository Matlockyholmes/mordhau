package be.vdab.mordhau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("os")
public class OsController {
    private static final String[] OSS = {"Windows","Macintosh","Android","Linux"};

    @GetMapping
    public ModelAndView osHelper(@RequestHeader("User-Agent") String userAgent,@RequestHeader("Accept-Language") String language){
        ModelAndView modelAndView = new ModelAndView("os");
        Arrays.stream(OSS).filter(os -> userAgent.contains(os)).findFirst().
                ifPresent(os -> modelAndView.addObject("os",os));
        modelAndView.addObject("language",languageHelper(language));
        return modelAndView;
    }
    public boolean languageHelper(String language){
        if(language.startsWith("en")){
            return true;
        }
        return false;
    }
}
