package Classes.Locations;

import java.util.ArrayList;
import java.util.Arrays;

import Enums.MiniLocations;

public class Hill extends Location {
    public Hill(String name) {
        super(name);
        this.curLocations = new ArrayList<>(Arrays.asList(
            MiniLocations.MINK,
            MiniLocations.BIG_ROCK
        ));
    }
}

