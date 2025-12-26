package Records;

import Classes.Locations.Location;
import Enums.MiniLocations;

public record HiderData(String hiderName, Location hiderLocation, MiniLocations hiderMiniLocation) {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HiderData hData)) return false;
        return hiderName.equalsIgnoreCase(hData.hiderName);
    }

    @Override
    public int hashCode() {
        return hiderName.toLowerCase().hashCode();
    }


    @Override
    public String toString() {
        return "HiderData{" +
            "hiderName='" + hiderName + '\'' +
            ", hiderLocation=" + hiderLocation +
            ", hiderMiniLocation=" + hiderMiniLocation +
            '}';
    }
}
