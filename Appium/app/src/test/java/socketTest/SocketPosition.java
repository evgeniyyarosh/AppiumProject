package socketTest;

import org.junit.Before;
import org.junit.BeforeClass;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by eugene.iarosh on 2/22/2017.
 */

public class SocketPosition {
    protected Socket socket;


    @Before
    public void setUp(){
        try {
            socket = IO.socket("http://dev.traccar.itcraft.i-it.pro:9092");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
