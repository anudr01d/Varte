
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private String uri;
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
