package pl.kurs.springhwrkweek5.model;

public class CityParam {
    String city;

    public CityParam() {
    }

    @Override
    public String toString() {
        return "CityParam{" +
                "city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
