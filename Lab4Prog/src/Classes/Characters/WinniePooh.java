package Classes.Characters;

import Classes.Control;
import Classes.Location;
import Enums.Weather;
import Exceptions.CookiesEatingException;

public class WinniePooh extends Character {
    public WinniePooh(String name, int cookiesCount, int eatSpeed) throws CookiesEatingException {
        super(name);
        this.cookiesCount = cookiesCount;
        
        if (eatSpeed <= 0) { 
            throw new CookiesEatingException("Ой-ой, кажется " + name + " не сможет наесться печеньками :("); 
        } else this.eatSpeed = eatSpeed;
    }

    @Override
    public String makeSound(Character targetCharacter) {
        String targetName = targetCharacter.getName();

        String[] sounds = { 
            "Это Винни-Пух, ты где, " + targetName + "?", 
            targetName + ", ты куда пропал?", 
            targetName + " пойдем ко мне домой пить мёд с печеньками" 
        };
        return sounds[(Control.RANDOM.nextInt(sounds.length))];
    }

    @Override
    public void eat(Location location) {
        Weather currentWeather = location.getWeather();
        
        switch (currentWeather) {
            case 
            SUNNY, 
            GOOD,
            CHEERFUL,
            WARM,
            FUNNY:
                this.cookiesCount -= this.eatSpeed - 1;
                break;
            case 
            CLOUDY, 
            PACIFIC:
                this.cookiesCount -= this.eatSpeed;
                break;
            default:
                this.cookiesCount -= this.eatSpeed + 2;
                break;
        }
    }   
}
