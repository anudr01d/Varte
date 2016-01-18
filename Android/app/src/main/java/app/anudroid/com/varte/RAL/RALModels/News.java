package app.anudroid.com.varte.RAL.RALModels;

/**
 * Created by Anudeep on 22/12/15.
 */
public class News {
    private String _headline;

    public News(String headline){
        _headline = headline;
    }

    public String get_headline() {
        return _headline;
    }

    public void set_headline(String _headline) {
        this._headline = _headline;
    }
}