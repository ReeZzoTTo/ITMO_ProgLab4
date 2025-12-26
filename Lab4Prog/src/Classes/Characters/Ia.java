package Classes.Characters;

import Classes.Control;
import Classes.Locations.Location;
import Enums.Weather;
import Exceptions.CookiesEatingException;

public class Ia extends Character {
    public Ia(String name, int cookiesCount, int eatSpeed) throws CookiesEatingException {
        super(name);
        this.cookiesCount = cookiesCount;
        if (eatSpeed >= 3 && eatSpeed <= 0) { 
            throw new CookiesEatingException("Ой-ой, кажется " + name + " не сможет наесться печеньками :(");
        }
        else { this.eatSpeed = eatSpeed; }
    }

    @Override
    public String makeSound(Character targetCharacter) {
        String targetName = targetCharacter.getName();

        String[] sounds = { 
            "Доброе утро " + targetName + ", в чём я лично очень сомневаюсь!",
            "Несчастные случаи — очень странные штуки. Они обычно случаются совершенно случайно.",
            "И я, И я, И я того же мнения!"
        };
        return sounds[(Control.RANDOM.nextInt(sounds.length))];
    }

    @Override
    public void eat(Location location) {
        Weather currentWeather = location.getWeather();
        
        switch (currentWeather) {
            case 
            Weather.SUNNY, 
            Weather.GOOD,
            Weather.CHEERFUL,
            Weather.WARM,
            Weather.PACIFIC,
            Weather.FUNNY:
                this.cookiesCount -= this.eatSpeed - 1;
                break;
            default:
                this.cookiesCount -= this.eatSpeed;
                break;
        }
    }   
}
