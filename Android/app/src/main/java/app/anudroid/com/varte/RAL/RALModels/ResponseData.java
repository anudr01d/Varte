
package app.anudroid.com.varte.RAL.RALModels;

import java.util.ArrayList;
import java.util.List;

public class ResponseData {

    private String query;
    private List<Entry_> entries = new ArrayList<Entry_>();

    /**
     * 
     * @return
     *     The query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The entries
     */
    public List<Entry_> getEntries() {
        return entries;
    }

    /**
     * 
     * @param entries
     *     The entries
     */
    public void setEntries(List<Entry_> entries) {
        this.entries = entries;
    }

}
