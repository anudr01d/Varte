
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentRss {

    private String wfw;
    private String content;

    /**
     * 
     * @return
     *     The wfw
     */
    public String getWfw() {
        return wfw;
    }

    /**
     * 
     * @param wfw
     *     The wfw
     */
    public void setWfw(String wfw) {
        this.wfw = wfw;
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
