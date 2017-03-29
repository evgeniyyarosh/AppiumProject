package socketTest.socketsettings;

import com.google.gson.Gson;
import java.util.Arrays;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import socketTest.models.BasePacketModel;
import socketTest.models.Location;


public class SocketManager {
    private static final String AUTH_EVENT = "auth";
    private static final String UPDATE_POSITION_EVENT = "updatePosition";
    private boolean socketAuthorized;
    private TrackerSocketListener listener;
    private Emitter.Listener authListener = authSocketListener();
    private String token;
    private Socket socket;
    private Emitter.Listener locationListener = updatePositionListener();


    public interface TrackerSocketListener {
        void onAuthSuccessfully();
    }


    private void authorize(String token) {
        if (socket != null) {
            socket.emit(AUTH_EVENT, token);
        }
    }


    private void subscribeOnSocketEvents() {
        if (socket != null) {
            socket.on(Socket.EVENT_CONNECT, args -> {
                authorize(token);
                System.out.println("Socket EVENT_CONNECT " + args.toString());
            });

            socket.on(Socket.EVENT_CONNECT_ERROR, args -> {
                System.out.println("Socket EVENT_CONNECT_ERROR " + args.toString());
            });

            socket.on(Socket.EVENT_ERROR, args -> {
                System.out.println("Socket EVENT_ERROR " + args.toString());
            });

            socket.on(Socket.EVENT_MESSAGE, args -> {
                System.out.println("Socket EVENT_MESSAGE " + args.toString());
            });
            socket.on(AUTH_EVENT, authListener);

            socket.on(UPDATE_POSITION_EVENT, locationListener);
        } else {
            System.out.println("Socket in subscribeOnSocketEvents is NULL ");
        }
    }

    public void socketConnect() {
        if (socket != null) {
            subscribeOnSocketEvents();  //subscribe on events
            socket.connect();
        } else {
            System.out.println("Socket in socketConnect is Null");
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

    private Emitter.Listener updatePositionListener() {
        return args -> {
            if (args != null && args.length > 0){
               Gson gson = new Gson();
                Location location = gson.fromJson(args[0].toString(), Location.class);
                System.out.println("Socket location" +  Arrays.toString(args));
            }
        };
    }

    private Emitter.Listener authSocketListener() {
        return new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                if (args != null && args.length > 0) {
                    System.out.println("Socket auth = " + args[0]);
                    Gson gson = new Gson();
                    BasePacketModel auth = gson.fromJson(String.valueOf(args[0]), BasePacketModel.class);
                    socketAuthorized = auth.getSuccess();
                    if (!socketAuthorized) {
                        String error = auth.getError();
                        System.out.println(this.getClass().getSimpleName() + AUTH_EVENT + " " + error);
                    } else {
                        listener.onAuthSuccessfully();
                    }

                }
            }
        };
    }
}
