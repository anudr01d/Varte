
package app.anudroid.com.varte.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headers {

    private List<Header> header = new ArrayList<Header>();

    /**
     * 
     * @return
     *     The header
     */
    public List<Header> getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    public void setHeader(List<Header> header) {
        this.header = header;
    }

}
