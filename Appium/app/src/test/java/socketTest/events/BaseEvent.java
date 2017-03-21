package socketTest.events;

/**
 * Created by eugene.iarosh on 3/20/2017.
 */

public class BaseEvent<Data> {

    public static final int DISPLAY_BUS_LOCATION_EVENT = 1;
    public static final int SYNC_COMPLETE_EVENT = 2;
    public static final int LOCATION_UPDATE_EVENT = 3;
    public static final int UPDATE_DRIVER_ROUTE_EVENT = 4;
    public static final int SYNC_START_EVENT = 5;
    public static final int BUS_DELETED_EVENT = 6;
    public static final int CLOSE_SOCKET_EVENT = 7;
    public static final int LOGOUT_EVENT = 8;
    public static final int RECONNECT_SOCKET_EVENT = 9;
    public static final int PROFILE_UPDATE_EVENT = 10;
    public static final int BUS_ARRIVE_EVENT = 11;
    public static final int CONNECTION_CHANGE_EVENT = 12;
    public static final int BUS_LOCATION_EVENT = 13;
    public static final int BUS_HISTORY_EVENT = 14;
    public static final int ROUTE_STATUS_CHANGED_EVENT = 15;
    public static final int OFFLINE_MODE_EVENT = 16;
    public static final int STUDENT_CHANGED_EVENT = 17;
    public static final int UPDATE_ROUTE_PARENT_EVENT = 18;
    public static final int SETTINGS_UPDATE_EVENT = 19;
    public static final int SCHOOL_UPDATE_EVENT = 20;
    public static final int STUDENT_NOT_LINKED_EVENT = 21;
    public static final int REQUEST_LOCATION_HISTORY_EVENT = 22;
    public static final int START_AS_TRACKER_EVENT = 23;
    public static final int GPS_OFF_EVENT = 24;
    public static final int FINISH_TRACKERMODE_EVENT = 25;
    public static final int START_SCAN_BEACONS = 26;
    public static final int STOP_SCAN_BEACONS = 27;
    public static final int STUDENT_APPROOVED_EVENT = 28;
    public static final int LOCATION_NOT_GRANTED_EVENT = 29;
    public static final int REJECTED_STUDENT_EVENT = 30;

    private int eventType;
    private Data data;

    public BaseEvent(int eventType, Data data) {
        this.eventType = eventType;
        this.data = data;
    }

    public BaseEvent(int eventType) {
        this.eventType = eventType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
