package Classes.Locations;

import java.util.ArrayList;
import java.util.Arrays;

import Enums.MiniLocations;

public class GloomyPlace extends Location {
    public GloomyPlace(String name) {
        super(name);
        this.curLocations = new ArrayList<>(Arrays.asList(
            MiniLocations.IA_HOME,
            MiniLocations.LAKE
        ));
    }
}
