public class City {
    public String name;
    public String country;
    public double temperature;

    public City(String name, String country, double temperature) {
        this.name = name;
        this.country = country;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
