package be.vdab.mordhau.controllers;

import be.vdab.mordhau.Domain.Adres;
import be.vdab.mordhau.Domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.Calendar;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView index(@CookieValue(name = "visited", required = false) String visited, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("index","welcome",hourChecker());
        modelAndView.addObject("activity",prayingOrSlaughtering());
        modelAndView.addObject("webadmin",new Person("Matthias","Heylen",0,false,
                new Adres("Vitsenveld","87",2550,"Kontich")));
        Cookie cookie = new Cookie("visited","yes");
        cookie.setMaxAge(31_536_000);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(visited != null){
            modelAndView.addObject("visited",true);
        }
        return modelAndView;
    }

    private String hourChecker(){
        int hour = LocalTime.now().getHour();
        if (hour < 12){
           return  "morning";
        } else if (hour < 18){
            return "Afternoon";
        } else {
            return "evening";
        }
    }

    private String prayingOrSlaughtering(){
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (day == 2 || day == 5){
            return "praying";
        } else {
            return "slaughtering";
        }
    }
}
