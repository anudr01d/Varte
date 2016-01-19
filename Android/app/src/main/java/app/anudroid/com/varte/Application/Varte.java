package app.anudroid.com.varte.Application;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.otto.Bus;

import app.anudroid.com.varte.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

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
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
