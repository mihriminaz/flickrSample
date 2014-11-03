package  com.mihri.FlickrApp.flickrutil;

import java.io.Serializable;
import java.util.List;

import android.util.Log;

/**
 * Created by Mihri Minaz on 12/03/14.
 */
public class PhotoSearch implements Serializable {
    private String id;
   // private String owner;
   // private String ownername;
    private String page;
    private String pages;
   // private String per_page;
    private String perpage;

    public List<Photo> getPhoto() {

        Log.v("Currenturl", photo.toString());
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    private List<Photo> photo;
    //private String primary;
    //private String title;
    private String total;
}
