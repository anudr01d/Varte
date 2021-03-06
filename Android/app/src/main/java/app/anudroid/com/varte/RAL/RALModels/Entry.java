
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Link_ link;
    @JsonIgnore
    List<Category> category = new ArrayList<Category>();
    @JsonIgnore
    Author author;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String id;
    @JsonIgnore
    String updated;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String published;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Summary summary;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    CommentRss commentRss;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Comments comments;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    OrigLink origLink;
    @JsonIgnore
    String creator;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String date;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String url;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String contentSnippet;

    private boolean isAdded;

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public String getContentSnippet() {
        return contentSnippet;
    }

    public void setContentSnippet(String contentSnippet) {
        this.contentSnippet = contentSnippet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Entry() {
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The link
     */
    public Link_ getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(Link_ link) {
        this.link = link;
    }

    /**
     * @return The category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }

    /**
     * @return The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * @param updated The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * @return The published
     */
    public String getPublished() {
        return published;
    }

    /**
     * @param published The published
     */
    public void setPublished(String published) {
        this.published = published;
    }

    /**
     * @return The summary
     */
    public Summary getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    /**
     * @return The commentRss
     */
    public CommentRss getCommentRss() {
        return commentRss;
    }

    /**
     * @param commentRss The commentRss
     */
    public void setCommentRss(CommentRss commentRss) {
        this.commentRss = commentRss;
    }

    /**
     * @return The comments
     */
    public Comments getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    public void setComments(Comments comments) {
        this.comments = comments;
    }

    /**
     * @return The origLink
     */
    public OrigLink getOrigLink() {
        return origLink;
    }

    /**
     * @param origLink The origLink
     */
    public void setOrigLink(OrigLink origLink) {
        this.origLink = origLink;
    }

    /**
     * @return The creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator The creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

}
