package socketTest.socketsettings;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Arrays;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import socketTest.events.BaseEvent;
import socketTest.models.BasePacketModel;

/**
 * Created by eugene.iarosh on 3/20/2017.
 */

public class SocketManager {
    private static final String AUTH_EVENT = "auth";
    private static final String UPDATE_POSITION_EVENT = "updatePosition";
    private static final String ROUTE_STATUS_CHANGE_EVENT = "updateBus";
    private static final String LOCATION_STATISTICS_FOR_PERIOD = "historyByDeltaTime";
    private static final String USER_ROLE_DRIVER ="driver";
    private boolean socketAuthorized;
    private TrackerSocketListener listener;
    private Emitter.Listener authListener = authSocketListener();
    private String token;
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }



    private Emitter.Listener authSocketListener() {
        return new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                if (args != null && args.length > 0) {
                    System.out.println(args[0]);
                    /*Gson gson = new Gson();
                    BasePacketModel auth = gson.fromJson(String.valueOf(args[0]), BasePacketModel.class);*/
                   // socketAuthorized = auth.getSuccess();
                    if (!socketAuthorized) {
                      //  String error = auth.getError();
                    } else {
                        listener.onAuthSuccessfully();
                    }

                }
            }
        };
    }
    public interface TrackerSocketListener {
        void onAuthSuccessfully();
    }




    private void subscribeOnSocketEvents() {
        if (socket != null) {
            socket.on(Socket.EVENT_CONNECT, args -> {
                authorize(token);
            });
            socket.on(Socket.EVENT_ERROR, args -> System.out.println(( "Socket error " + Arrays.toString(args))));
            socket.on(AUTH_EVENT, authListener);
        }
    }

    private void authorize(String token) {
        if (socket != null /*&& !socketAuthorized*/) {
            socket.emit(AUTH_EVENT, token);
        }
    }


    public void socketConnect() {
        if (socket != null) {
            subscribeOnSocketEvents();
            socket.connect();
        }
    }

    public void socketDisconnect() {
        if (socket != null) {
            socket.disconnect();
            socket.off();
        }
    }

    public SocketManager(String token, TrackerSocketListener listener, Socket socket) {
        this.listener = listener;
        this.token = token;
        this.socket = socket;
    }
}
