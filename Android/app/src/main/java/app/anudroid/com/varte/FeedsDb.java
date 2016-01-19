package app.anudroid.com.varte;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by anudeep on 1/19/2016.
 */
@Database(name = FeedsDb.NAME, version = FeedsDb.VERSION)
public class FeedsDb {
    public static final String NAME = "Feeds";
    public static final int VERSION = 1;
}
