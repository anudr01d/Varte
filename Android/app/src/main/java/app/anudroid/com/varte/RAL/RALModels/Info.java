
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uri;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String feedburner;

    /**
     * 
     * @return
     *     The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 
     * @return
     *     The feedburner
     */
    public String getFeedburner() {
        return feedburner;
    }

    /**
     * 
     * @param feedburner
     *     The feedburner
     */
    public void setFeedburner(String feedburner) {
        this.feedburner = feedburner;
    }

}
