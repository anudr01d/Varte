package app.anudroid.com.varte.Application;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by Anudeep on 27/12/15.
 */
public class Varte extends Application{
    private static Bus sEventBus;

    public static Bus getEventBus() {
        if(sEventBus==null) {
            sEventBus = new com.squareup.otto.Bus();
        }
        return sEventBus;
    }
}
