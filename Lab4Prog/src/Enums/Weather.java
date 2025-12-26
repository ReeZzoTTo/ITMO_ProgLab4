package Enums;

import Classes.Control;

public enum Weather {
    GOOD("хорошая"),            
    FUNNY("весёлая"),
    CHEERFUL("жизнерадостная"),
    HOT("жаркая"),
    WARM("тёплая"),
    PACIFIC("спокойная"),
    SUNNY("солнечная"),
    RAINY("дождливая"),
    CLOUDY("облачная"),
    WINDY("ветреная"),
    SNOWY("снежная"),
    FOGGY("туманная"),
    STORMY("штормовая");

    private final String description;

    Weather(String description) {
        this.description = description + " погода";
    }

    public String getDescription() {
        return this.description;
    }

    public static Weather getRandomWeather() {
        Weather[] weathers = values();
        return weathers[Control.RANDOM.nextInt(weathers.length)];
    }
}
