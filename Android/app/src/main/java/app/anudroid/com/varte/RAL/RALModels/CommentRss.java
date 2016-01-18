
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentRss {

    @JsonInclude(JsonInclude.Include.NON_NULL)
     String wfw;
    @JsonInclude(JsonInclude.Include.NON_NULL)
     String content;

    public CommentRss(){}

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
