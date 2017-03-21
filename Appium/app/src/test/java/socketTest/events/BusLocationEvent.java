package socketTest.events;


import socketTest.models.Location;

/**
 * Created by eugene.iarosh on 3/20/2017.
 */

public class BusLocationEvent {
    private Location location;

    /* Parameter need to specify is location new and need to store it to db,
     or if location from database already need only to analyze location on route, not need to save it gain */
    private boolean needStoreToDb;

    public BusLocationEvent(Location location, boolean storeToDb){
        this.location = location;
        this.needStoreToDb = storeToDb;
    }
    public Location getLocation() {
        return location;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BusLocationEvent step = (BusLocationEvent) obj;
        return location.equals(step.location);
    }
}
