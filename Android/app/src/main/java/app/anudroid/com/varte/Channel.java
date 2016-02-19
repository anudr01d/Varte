package app.anudroid.com.varte;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by anudeep on 1/18/2016.
 */
@Parcel
@ModelContainer
@Table(database = FeedsDb.class)
public class Channel extends BaseModel{
    @PrimaryKey(autoincrement = true)
    public long ChannelId;

    @Column
    public String Title;

    @Column
    public String url;


    public List<Entry> entries;
    @OneToMany(methods = {OneToMany.Method.SAVE, OneToMany.Method.DELETE}, variableName = "entries")
    public List<Entry> getAllEntries() {
        if (entries == null || entries.isEmpty()) {
            entries = SQLite.select()
                    .from(Entry.class)
                    .where(Entry_Table.channelForeignKeyContainer_ChannelId.eq(ChannelId))
                    .queryList();
        }
        return entries;
    }
}
