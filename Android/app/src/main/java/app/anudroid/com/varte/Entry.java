package app.anudroid.com.varte;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.container.ForeignKeyContainer;

import org.parceler.Parcel;

/**
 * Created by anudeep on 1/18/2016.
 */
@Parcel(analyze = Entry.class)
@Table(database = FeedsDb.class)
public class Entry extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public long EntryId;
    @Column
    public String Content;
    @Column
    public String Title;
    @Column
    public String TimeStamp;

    @ForeignKey(saveForeignKeyModel = false)
    transient ForeignKeyContainer<Channel> channelForeignKeyContainer;

    public void associateChannel(Channel channel) {
        channelForeignKeyContainer = FlowManager.getContainerAdapter(Channel.class).toForeignKeyContainer(channel);
    }
}
