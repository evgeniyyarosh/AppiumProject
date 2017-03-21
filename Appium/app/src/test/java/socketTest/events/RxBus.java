package socketTest.events;


import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by eugene.iarosh on 3/20/2017.
 */

public class RxBus {
    private static RxBus instance;

    private PublishSubject<BaseEvent> subject = PublishSubject.create();

    public static RxBus instanceOf() {
        if (instance == null) {
            instance = new RxBus();
        }
        return instance;
    }

    /**
     * Pass any event down to event listeners.
     */
    public void setString(BaseEvent event) {
        subject.onNext(event);
    }

    /**
     * Subscribe to this Observable. On event, do something
     * e.g. replace a fragment
     */
    public Observable<BaseEvent> getEvents() {
        return subject;
    }
}
