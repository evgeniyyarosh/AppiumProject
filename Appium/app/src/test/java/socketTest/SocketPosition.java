package socketTest;

import org.junit.Before;
import org.junit.Test;

import io.socket.client.IO;
import io.socket.client.Socket;
import socketTest.socketsettings.Constants;
import socketTest.socketsettings.SocketManager;
import socketTest.socketsettings.Timer;

public class SocketPosition implements SocketManager.TrackerSocketListener {
    private SocketManager socketManager;
    private Socket socket;
    private static final String TOKEN = "ydKe8pUclFWxy9qqR0LPTA3asrjeSTuWBdp4gPyz5mSyGh7GvIT1e2ak8SX1";
    private Timer timer;

    @Before
    public void init(){
        timer = new Timer();
    }

    @Test
    public void firstTest() throws Exception {
        socket = IO.socket(Constants.BUS_SERVER_URL);
        socketManager = new SocketManager(TOKEN, this, socket);
        socketManager.socketConnect();

        timer.start();
        while (!timer.expired(15)){
        }
        socketManager.socketDisconnect();
    }
    @Override
    public void onAuthSuccessfully() {
    }
   }
