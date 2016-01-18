
package app.anudroid.com.varte.RAL.RALModels;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String xmlns;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonIgnore
    private List<Link> link = new ArrayList<Link>();
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String subtitle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updated;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updatePeriod;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updateFrequency;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Info info;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String language;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Entry> entry = new ArrayList<Entry>();

    /**
     * 
     * @return
     *     The xmlns
     */
    public String getXmlns() {
        return xmlns;
    }

    /**
     * 
     * @param xmlns
     *     The xmlns
     */
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    /**
     * 
     * @return
     *     The dc
     */
    public String getDc() {
        return dc;
    }

    /**
     * 
     * @param dc
     *     The dc
     */
    public void setDc(String dc) {
        this.dc = dc;
    }

    /**
     * 
     * @return
     *     The sy
     */
    public String getSy() {
        return sy;
    }

    /**
     * 
     * @param sy
     *     The sy
     */
    public void setSy(String sy) {
        this.sy = sy;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The link
     */
    public List<Link> getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(List<Link> link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 
     * @param subtitle
     *     The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 
     * @return
     *     The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *     The updatePeriod
     */
    public String getUpdatePeriod() {
        return updatePeriod;
    }

    /**
     * 
     * @param updatePeriod
     *     The updatePeriod
     */
    public void setUpdatePeriod(String updatePeriod) {
        this.updatePeriod = updatePeriod;
    }

    /**
     * 
     * @return
     *     The updateFrequency
     */
    public String getUpdateFrequency() {
        return updateFrequency;
    }

    /**
     * 
     * @param updateFrequency
     *     The updateFrequency
     */
    public void setUpdateFrequency(String updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    /**
     * 
     * @return
     *     The info
     */
    public Info getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The entry
     */
    public List<Entry> getEntry() {
        return entry;
    }

    /**
     * 
     * @param entry
     *     The entry
     */
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

}
