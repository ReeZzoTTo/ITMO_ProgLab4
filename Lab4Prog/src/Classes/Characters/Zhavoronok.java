package Classes.Characters;

import Classes.Locations.Location;
import Enums.Weather;
import Exceptions.CookiesEatingException;

public class Zhavoronok extends Character {
    public Zhavoronok(String name, int cookiesCount, int eatSpeed) throws CookiesEatingException {
        super(name);
        this.cookiesCount = cookiesCount;
        
        if (eatSpeed >= 2 && eatSpeed <= 0) {
            throw new CookiesEatingException("Ой-ой, кажется " + name + " не сможет наесться печеньками :(");
        }
        else { this.eatSpeed = eatSpeed; }
    }

    @Override
    public String makeSound(Character targetCharacter) {
        return "тюлип";
    }

    @Override
    public void eat(Location location) {
        Weather currentWeather = location.getWeather();
        
        switch (currentWeather) {
            case 
            Weather.HOT,
            Weather.RAINY,
            Weather.SNOWY,
            Weather.FOGGY,
            Weather.STORMY:
                this.cookiesCount -= this.eatSpeed - 1;
            default:
                this.cookiesCount -= this.eatSpeed;
                break;
        }
    }   
}
