package be.vdab.mordhau.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Calendar;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String mordhauPageMaker(){
        return new StringBuffer("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>MordhauProject</title>\n" +
                "    <link rel=\"icon\" href=\"icons/mordhauico.ico\" type=\"image/x-icon\">\n" +
                "    <link rel=\"stylesheet\" href=\"css/mordhau.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Mordhau Springbawt project</h1>\n" +
                "<img src=\"images/indexhau.jpg\" alt=\"index pic\" class=\"fullwidth\">\n")
        .append(welcomeManagement())
        .append(openOrClosedValidator())
        .append("</body>\n</html>")
        .toString();
    }
    public String welcomeManagement(){
        int currentHour = LocalTime.now().getHour();
        if(currentHour < 12){
            return("<h2>Good Morning</h2>\n");
        } else if(currentHour < 18){
            return("<h2>Good Afternoon</h2>\n");
        } else {
            return("<h2>Good Night</h2>\n");
        }
    }
    public String openOrClosedValidator(){
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        return currentDay == 2 || currentDay == 5 ? "<h3>No slaughter on mondays & thursdays</h3>\n" : "<h3>Time for slaughter</h3>\n";
    }
}
