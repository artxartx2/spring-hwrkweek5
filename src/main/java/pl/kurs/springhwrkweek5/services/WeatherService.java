package pl.kurs.springhwrkweek5.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kurs.springhwrkweek5.model.weather.Weather;

@Service
public class WeatherService {
    @Value("${apiKey}")
    private String apiKey;
    @Value("${apiBaseUrl}")
    private String baseUrl;


    public Weather getWeather(String city) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(getApiUrl(city), Weather.class);
    }

    public String getApiUrl(String city) {
        StringBuilder address = new StringBuilder(baseUrl);
        address.append("/current?access_key=");
        address.append(apiKey);
        address.append("&query=");
        address.append(city);
        return address.toString();

    }
}
