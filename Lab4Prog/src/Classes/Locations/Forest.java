package Classes.Locations;

import java.util.ArrayList;
import java.util.Arrays;

import Enums.MiniLocations;

public class Forest extends Location {
    public Forest(String name) {
        super(name);
        this.curLocations = new ArrayList<>(Arrays.asList(
            MiniLocations.HONNEY_TREE,
            MiniLocations.POND,
            MiniLocations.SHRUBS_ALLEY,
            MiniLocations.ROCKY_FIELD,
            MiniLocations.FLOWERBED
        ));
    }
}
