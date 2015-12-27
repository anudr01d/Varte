
package app.anudroid.com.varte.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Url {

    private String id;
    private String status;
    private Headers headers;
    private Redirect redirect;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The headers
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * 
     * @param headers
     *     The headers
     */
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    /**
     * 
     * @return
     *     The redirect
     */
    public Redirect getRedirect() {
        return redirect;
    }

    /**
     * 
     * @param redirect
     *     The redirect
     */
    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

}
