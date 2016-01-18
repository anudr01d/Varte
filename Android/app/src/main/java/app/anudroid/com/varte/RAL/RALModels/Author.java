
package app.anudroid.com.varte.RAL.RALModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.parceler.Parcel;

@Parcel
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @JsonInclude(JsonInclude.Include.NON_NULL)
     String name;

    public Author(){}
    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
