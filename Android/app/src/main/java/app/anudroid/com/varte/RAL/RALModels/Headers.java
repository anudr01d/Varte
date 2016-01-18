
package app.anudroid.com.varte.RAL.RALModels;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headers {

    @JsonInclude(JsonInclude.Include.NON_NULL)
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
