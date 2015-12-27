
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrigLink {

    private String feedburner;
    private String content;

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

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
