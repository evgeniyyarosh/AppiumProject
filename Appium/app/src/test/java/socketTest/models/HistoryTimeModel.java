package socketTest.models;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by natalia on 11/28/16.
 */

@Data
@NoArgsConstructor
public class HistoryTimeModel {
    @SerializedName("start")
    long startTime;
    @SerializedName("end")
    long endTime;
    @SerializedName("bus_id")
    long busId;
}
