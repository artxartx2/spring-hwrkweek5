package pl.kurs.springhwrkweek5.model;

public class PageParam {
    String country;
    String year;

    public PageParam() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "country='" + country + '\'' +
                ", year=" + year +
                '}';
    }
}
