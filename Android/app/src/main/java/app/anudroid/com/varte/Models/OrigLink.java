
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrigLink {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String feedburner;
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
