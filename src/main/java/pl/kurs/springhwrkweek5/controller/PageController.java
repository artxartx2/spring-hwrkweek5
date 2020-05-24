package pl.kurs.springhwrkweek5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.springhwrkweek5.model.CityParam;
import pl.kurs.springhwrkweek5.model.Holiday;
import pl.kurs.springhwrkweek5.model.PageParam;
import pl.kurs.springhwrkweek5.model.weather.Weather;
import pl.kurs.springhwrkweek5.services.HolidayService;
import pl.kurs.springhwrkweek5.services.WeatherService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class PageController {
    private HolidayService holidayService;
    private WeatherService weatherService;

    private String defaultCountry;
    private Integer defaultYear;

    private List<Holiday> holidayList;
    private Weather weather;

    public PageController(HolidayService holidayService, WeatherService weatherService) {
        this.holidayService = holidayService;
        this.weatherService = weatherService;

    }

    @GetMapping("/holiday")
    public String displayHolidayList(Model model) {
        model.addAttribute("holidays", holidayList);
        PageParam fHoliday = new PageParam();
        model.addAttribute("fHoliday", fHoliday);
        return "pageHoliday";
    }

    @PostMapping("/holiday/go")
    public String getHolidayList(@ModelAttribute PageParam fHoliday) {
        holidayList = Arrays.asList(holidayService.getHolidays(fHoliday));
        return "redirect:/holiday";
    }

    @GetMapping("/weather")
    public String displayWeather(Model model) {
        CityParam fCity = new CityParam();
        model.addAttribute("weather", weather);
        model.addAttribute("fCity", fCity);

        if (weather == null) {
            model.addAttribute("status", false);
            model.addAttribute("info", "I'm waiting for You ...");
        } else {
            if (!weather.getAdditionalProperties().isEmpty()) {
                Boolean result = (Boolean) weather.getAdditionalProperties().get("success");
                HashMap<String, Object> message = (HashMap<String, Object>) weather.getAdditionalProperties().get("error");
                String info = (String) message.get("info");
                model.addAttribute("status", result);
                model.addAttribute("info", info);
            } else {
                model.addAttribute("status", true);
                model.addAttribute("info", "");
            }
        }

        return "pageWeather";
    }

    @PostMapping("/weather/go")
    public String getWeatherInfo(@ModelAttribute CityParam fCity) {
        weather = weatherService.getWeather(fCity.getCity());

        return "redirect:/weather";
    }


}
