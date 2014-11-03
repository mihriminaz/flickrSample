package  com.mihri.FlickrApp.flickrutil;

import  com.mihri.FlickrApp.flickrutil.JSONObject.PhotoSearchsJSON;
import com.mihri.FlickrApp.flickrutil.JSONObject.PhotoSetsJSON;
import com.hintdesk.core.utils.JSONHttpClient;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotoSearchs extends FlickrBaseItem {

    public PhotoSearchs(String api_key, String format) {
        super(api_key, format);

    }

    public List<Photo> getPhotos() {
        JSONHttpClient jsonHttpClient = new JSONHttpClient();
        String url = String.format(FlickrUrls.flickr_photos_searchPhotos, format, api_key);
        PhotoSearchsJSON photoSearchJson = jsonHttpClient.Get(url, new ArrayList<NameValuePair>(), PhotoSearchsJSON.class);
        return photoSearchJson.getPhotoSearch().getPhoto();
    }
   
}
