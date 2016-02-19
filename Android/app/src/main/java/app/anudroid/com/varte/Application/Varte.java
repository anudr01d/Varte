package app.anudroid.com.varte.Application;

import android.app.Application;
import android.util.Log;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.raizlabs.android.dbflow.config.FlowManager;

import app.anudroid.com.varte.Bus.RxBus;
import app.anudroid.com.varte.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Anudeep on 27/12/15.
 */
public class Varte extends Application{

    private static RxBus _rxBus = null;
    public static RxBus getRxBusSingleton() {
        if (_rxBus == null) {
            _rxBus = new RxBus();
        }

        return _rxBus;
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

        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.NO_ENCRYPTION)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))
                .build();
    }
}
