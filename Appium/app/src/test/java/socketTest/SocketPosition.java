package socketTest;

import android.util.Log;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.EventListener;
import java.util.HashMap;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import rx.Subscription;
import socketTest.events.BaseEvent;
import socketTest.events.BusLocationEvent;
import socketTest.events.RxBus;
import socketTest.socketsettings.Constants;
import socketTest.socketsettings.InitSocket;
import socketTest.socketsettings.SocketManager;
import socketTest.socketsettings.Timer;

/**
 * Created by eugene.iarosh on 2/22/2017.
 */

public class SocketPosition implements SocketManager.TrackerSocketListener {
    private Timer timer;
    private SocketManager socketManager;
    private static final String TOKEN = "wAc46kzSfXNOS3V9dmx16ZTKnxmJlmMzvuVfRRNmxkLACkIEVEufD8Xes10Y";
    private HashMap <Integer, EventListener> eventListener;
    private Socket socket;

    @Before
    public void init(){
        timer = new Timer();
    }

    @Test
    public void firstTest() throws Exception {

       try {
            socket = IO.socket(Constants.BUS_SERVER_URL);

        }catch (Exception e){}
        socketManager = new SocketManager(TOKEN, this, socket);
        //Thread.sleep(1000);
        socketManager.socketConnect();

        timer.start();
        while (!timer.expired(5)){
        }
        socketManager.socketDisconnect();
    }

    @Override
    public void onAuthSuccessfully() {
    }

    public void busLocation(BaseEvent<BusLocationEvent> event) {
        BusLocationEvent busLocationEvent = event.getData();
        if (busLocationEvent == null) {
            return;
        }
    }

    public interface EventListener {
        void event(BaseEvent baseEvent);
    }

    private void subscribeOnBusLocationEvent(HashMap <Integer, EventListener> eventListener) {
        Subscription rxBusSubscription = RxBus.instanceOf().getEvents()
                .subscribe(event -> {
                    if (eventListener.containsKey(event.getEventType())) {
                        eventListener.get(event.getEventType()).event(event);
                    }
                }, Throwable::printStackTrace);
    }
}
