package socketTest.socketsettings;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by eugene.iarosh on 3/16/2017.
 */

public class InitSocket {
    private Socket socket;
    {
        try {
            socket = IO.socket(Constants.BUS_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
