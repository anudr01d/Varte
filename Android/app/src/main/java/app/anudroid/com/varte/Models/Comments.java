
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {

    private String slash;
    private String content;

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
