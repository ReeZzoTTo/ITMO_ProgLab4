package Enums;

public enum MiniLocations {
    HONNEY_TREE("медовое дерево"),
    POND("пруд"),
    ROCKY_FIELD("каменистая поляна"),
    SHRUBS_ALLEY("аллея кустарников"),
    FLOWERBED("клумба"),
    BIG_ROCK("большой камень"),
    MINK("норка"),
    IA_HOME("домик Иа"),
    LAKE("озеро"),
    ROBIN_ROOM("комната Робина"),
    HALL("зал"),
    KITCHEN("кухня"),
    GARDEN("сад");

    private final String description;
    
    MiniLocations(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
