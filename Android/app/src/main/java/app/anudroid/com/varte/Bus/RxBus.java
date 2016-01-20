package app.anudroid.com.varte.Bus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subjects.SerializedSubject;

/**
 * Created by Anudeep on 27/12/15.
 */
public class RxBus {

    private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public void send(Object o) {
        _bus.onNext(o);
    }

    public Observable<Object> toObserverable() {
        return _bus;
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }

    public static class RxEvent {
        Object obj;
        public RxEvent(Object ob) {
            obj=ob;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    };
}