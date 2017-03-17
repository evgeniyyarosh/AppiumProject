package com.smartnavigationsystems.ourschoolbus.sockets;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by natalia on 10/3/16.
 */

@Data
@NoArgsConstructor
public class Location {

    @SerializedName("isHwTracker")
    boolean isHwTracker;

    @SerializedName("lat")
    double lat;

    @SerializedName("lng")
    double lng;

    @SerializedName("route_id")
    int routeId;

    @SerializedName("bus_id")
    int busId;

    @SerializedName("time")
    long time;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Location location = (Location) obj;
        return lat == location.lat &&
                lng == location.lng &&
                routeId == location.routeId &&
                busId == location.busId &&
                time == location.time;
    }

}
