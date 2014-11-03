package  com.mihri.FlickrApp.flickrutil;

import android.util.Log;

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

    public PhotoSearchs(String api_key, String format, double lat, double lon) {
        super(api_key, format);

    }

    public List<Photo> getPhotos() {

        Log.v("Currenturl", "skfjlksdjg");
        JSONHttpClient jsonHttpClient = new JSONHttpClient();
        String url = String.format(FlickrUrls.flickr_photos_searchPhotos, format, api_key);
       
       Log.v("Currenturl", url);
       
        PhotoSearchsJSON photoSearchJson = jsonHttpClient.Get(url, new ArrayList<NameValuePair>(), PhotoSearchsJSON.class);

        Log.v("Currenturl", photoSearchJson.toString());
       
        return photoSearchJson.getPhotoSearch().getPhoto();
    }
   
}
