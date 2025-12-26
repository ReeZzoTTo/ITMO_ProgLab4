package Enums;

import Classes.Control;

public enum Feelings {
    QUIET("тихо"), 
    RESTLESS("беспокойно"), 
    CALM("спокойно"),
    WINDY("ветрено"), 
    COOL("прохладно"), 
    COLD("холодно"), 
    SCARY("страшно");

    private final String description;

    Feelings(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static Feelings getRandomFeeling() {
        Feelings[] feelings = values();
        return feelings[Control.RANDOM.nextInt(feelings.length)];
    }
}
