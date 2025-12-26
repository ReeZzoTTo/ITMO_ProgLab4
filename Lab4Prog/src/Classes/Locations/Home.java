package Classes.Locations;

import java.util.ArrayList;
import java.util.Arrays;

import Enums.MiniLocations;

public class Home extends Location {
    public Home(String name) {
        super(name);
        this.curLocations = new ArrayList<>(Arrays.asList(
            MiniLocations.KITCHEN,
            MiniLocations.ROBIN_ROOM,
            MiniLocations.GARDEN,
            MiniLocations.HALL
        ));
    }
}
