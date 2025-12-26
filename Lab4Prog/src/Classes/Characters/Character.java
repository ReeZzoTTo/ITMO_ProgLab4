package Classes.Characters;

import java.util.Objects;

import Classes.Locations.Location;
import Enums.Actions;
import Enums.MiniLocations;

public abstract class Character {
    protected final String name;
    protected Location currentLocation;
    protected MiniLocations currentMiniLocation;
    protected int cookiesCount;
    protected int eatSpeed;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    } 

    public void currentMiniLocation(MiniLocations currentLocation) {
        this.currentMiniLocation = currentLocation;
    }

    public MiniLocations currentMiniLocation() {
        return this.currentMiniLocation;
    }

    public void currentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location currentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(Location location, MiniLocations curLocation) {
        this.currentLocation = location;
        this.currentMiniLocation = curLocation;
    }

    public int getCookiesCount() {
        return this.cookiesCount;
    }

    public void setCookiesCount(int cookiesCount) {
        this.cookiesCount = cookiesCount;
    }

    protected void setEatSpeed(int speed) {
        this.eatSpeed = speed;
    }

    protected int getEatSpeed() {
        return this.eatSpeed;
    }

    public String makeAction() {
        Actions currentAction = Actions.getRandomAction();
        return currentAction.getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Character that = (Character) obj;
        return Objects.equals(this.getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString() {
        return "Character{" +
            "name='" + name + '\'' +
            ", currentLocation=" + currentLocation +
            ", currentMiniLocation=" + currentMiniLocation +
            ", cookiesCount=" + cookiesCount +
            ", eatSpeed=" + eatSpeed +
            '}';
    }

    public abstract void eat(Location location);  
    public abstract String makeSound(Character targetCharacter);
}
