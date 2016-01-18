
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String slash;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String content;

    public Comments(){}

    /**
     * 
     * @return
     *     The slash
     */
    public String getSlash() {
        return slash;
    }

    /**
     * 
     * @param slash
     *     The slash
     */
    public void setSlash(String slash) {
        this.slash = slash;
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
