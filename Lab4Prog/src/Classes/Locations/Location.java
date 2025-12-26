package Classes.Locations;

import java.util.ArrayList;
import java.util.Objects;

import Enums.Feelings;
import Enums.MiniLocations;
import Enums.Weather;
import interfaces.LocationGetter;

public abstract class Location implements LocationGetter {
    protected final String name;
    protected Weather weather; 
    protected Feelings feeling;
    protected ArrayList<MiniLocations> curLocations;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return this.weather;
    }

    public String getWeatherText() {
        return this.weather.getDescription();
    }

    public void setFeeling(Feelings feeling) {
        this.feeling = feeling;
    }

    public Feelings getFeeling() {
        return this.feeling;
    }
    
    public String getFeelingDescription() {
        return this.feeling.getDescription();
    }

    public ArrayList<MiniLocations> getLocationList() {
        return this.curLocations;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Location that = (Location) obj;
        return Objects.equals(this.getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
    return "Location{" +
            "name='" + name + '\'' +
            ", weather=" + weather +
            ", feeling=" + feeling +
            '}';
    }

}
