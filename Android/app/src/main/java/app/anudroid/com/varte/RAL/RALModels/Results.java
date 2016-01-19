
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Feed feed;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Link link;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The feed
     */
    public Feed getFeed() {
        return feed;
    }

    /**
     * 
     * @param feed
     *     The feed
     */
    public void setFeed(Feed feed) {
        this.feed = feed;
    }

}
