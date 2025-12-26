package Enums;

import Classes.Control;

public enum Actions {
    COUGH("закашлял"), 
    SING("запел песню"), 
    CRY("заплакал"),
    SCREAM("закричал"), 
    LAUGH("начал смеятся");

    private final String description;

    Actions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static Actions getRandomAction() {
        Actions[] actionsList = values();
        return actionsList[Control.RANDOM.nextInt(actionsList.length)];
    }
}
