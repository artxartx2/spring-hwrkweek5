package pl.kurs.springhwrkweek5.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kurs.springhwrkweek5.model.weather.Weather;

@Service
public class WeatherServiceImpl {
    private String apiKey = "bd2241901403aba5ab8ce8899e2654c3";
    private String baseUrl = "http://api.weatherstack.com";
    private String apiUrl = "";

    public Weather getWeather(String city) {

        apiUrl = baseUrl + "/current?access_key=" + apiKey + "&query=" + city;
        RestTemplate restTemplate = new RestTemplate();
        Weather response = restTemplate.getForObject(apiUrl, Weather.class);

        return response;
    }
}
