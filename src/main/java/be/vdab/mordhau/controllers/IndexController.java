package be.vdab.mordhau.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.util.Calendar;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index","welcome",hourChecker());
        modelAndView.addObject("activity",prayingOrSlaughtering());
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
