package  com.mihri.FlickrApp.flickrutil;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class FlickrUrls {
	
    public static final String flickr_photos_searchPhotos = "https://www.flickr.com/services/rest/?method=flickr.photos.getRecent&format=%s&api_key=%s&per_page=5";//"https://www.flickr.com/services/rest/?method=flickr.photos.search&format=%s&api_key=%s&lat=36&lon=40&radius=10&per_page=5";
    public static final String flickr_photosets_getPhotos = "https://www.flickr.com/services/rest/?method=flickr.photosets.getPhotos&format=%s&api_key=%s&photoset_id=%s";
    public static final String flickr_photos_getSizes = "https://www.flickr.com/services/rest/?method=flickr.photos.getSizes&format=%s&api_key=%s&photo_id=%s";
}
