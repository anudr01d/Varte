
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link_ {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String href;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String rel;

    public Link_(){}

    /**
     * 
     * @return
     *     The href
     */
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 
     * @return
     *     The rel
     */
    public String getRel() {
        return rel;
    }

    /**
     * 
     * @param rel
     *     The rel
     */
    public void setRel(String rel) {
        this.rel = rel;
    }

}
