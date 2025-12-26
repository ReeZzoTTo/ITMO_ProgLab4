package Classes;

import java.util.ArrayList;
import java.util.Random;

import Classes.Locations.Location;

public class Control {
    static private ArrayList<Location> locationList;
    static public final Random RANDOM = new Random();
    static public ArrayList<String> resultText = new ArrayList<>();

    static public void addSentence(String sentence) {
        resultText.add(sentence);
    }

    static public ArrayList<String> getResultText() {
        return resultText;
    }

    static public void setLocations(ArrayList<Location> locList) {
        locationList = locList;
    }

    static public ArrayList<Location> getLocationList() {
        return locationList;
    }
}
