package com.smartnavigationsystems.ourschoolbus.sockets;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by natalia on 10/3/16.
 */

@Data
@NoArgsConstructor
public class BusLocation {

    @SerializedName("busId")
    int busId;

    @SerializedName("locations")
    List<Location> locations;

}
