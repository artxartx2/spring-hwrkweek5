package pl.kurs.springhwrkweek5.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kurs.springhwrkweek5.model.Holiday;
import pl.kurs.springhwrkweek5.model.PageParam;

@Service
public class HolidayServiceImpl {

    public Holiday[] getHolidays(PageParam params) {


        if (params.getCountry().isEmpty()) {
            params.setCountry("PL");
        }
        if (params.getYear().isEmpty()) {
            params.setYear("2020");
        }

        RestTemplate restTemplate = new RestTemplate();
        Holiday[] response = restTemplate.getForObject("https://date.nager.at/api/v2/publicholidays/" + params.getYear() + "/" + params.getCountry(), Holiday[].class);
        return response;


    }
}
