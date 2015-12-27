package app.anudroid.com.varte.Bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Anudeep on 27/12/15.
 */
public class BusProvider {
    private static final Bus bus = new Bus(ThreadEnforcer.ANY);

    public static Bus getInstance() {
        return bus;
    }
    private BusProvider(){};
}
