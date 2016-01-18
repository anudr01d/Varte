
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String href;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rel;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String atom10;

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

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The atom10
     */
    public String getAtom10() {
        return atom10;
    }

    /**
     * 
     * @param atom10
     *     The atom10
     */
    public void setAtom10(String atom10) {
        this.atom10 = atom10;
    }

}
