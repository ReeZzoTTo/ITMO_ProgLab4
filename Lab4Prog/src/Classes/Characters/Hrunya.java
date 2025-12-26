package Classes.Characters;

import Classes.Control;
import Classes.Locations.Location;
import Enums.Weather;
import Exceptions.CookiesEatingException;

public class Hrunya extends Character {
    public Hrunya(String name, int cookiesCount, int eatSpeed) throws CookiesEatingException {
        super(name);
        this.cookiesCount = cookiesCount;
        if (eatSpeed <= 3) { 
            throw new CookiesEatingException("Ой-ой, кажется " + name + " не сможет наесться печеньками :("); 
        } 
        
        else { this.eatSpeed = eatSpeed; }
    }

    @Override
    public String makeSound(Character targetCharacter) {
        String targetName = targetCharacter.getName();

        String[] sounds = { 
            "Это Хрюня, ты где, " + targetName + "?", 
            "Хрю-Хрю-Хрю-Хрю?", 
            targetName + ", это я, Хрю-Хрю, пойдем со мной" 
        };
        return sounds[Control.RANDOM.nextInt(sounds.length)];
    }

    @Override
    public void eat(Location location) {
        Weather currentWeather = location.getWeather();
        
        switch (currentWeather) {
            case 
            Weather.WINDY,
            Weather.FOGGY,
            Weather.SNOWY,
            Weather.STORMY:
                this.cookiesCount -= this.eatSpeed - 3;
                break;
            default:
                this.cookiesCount -= this.eatSpeed;
                break;
        }
    }   
}
