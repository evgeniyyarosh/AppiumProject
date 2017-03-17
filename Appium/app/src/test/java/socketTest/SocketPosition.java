package socketTest;

import org.junit.Before;
import org.junit.BeforeClass;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import socketTest.socketsettings.InitSocket;

/**
 * Created by eugene.iarosh on 2/22/2017.
 */

public class SocketPosition {
    public void creatConnection(){
        InitSocket initSocket = new InitSocket();
        final Socket socket = initSocket.getSocket();

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                socket.emit("auth", "IDhPaUiJYf19BaCyKAZ4bSXljIquyUoKRrIkBpbI2zAQ4OFJIdARIsNXgUTg");
                socket.disconnect();
            }

        }).on("auth", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                if (args != null && args.length > 0) {
                    String response = args[0].toString();

                }

            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        socket.connect();
    }
}
/*
socket.on("SetupMalls", new Emitter.Listener() {
@Override
public void call(Object... args) {
        if (args != null && args.length > 0) {
        String response = args[0].toString();

        }
        }
        })*/