package  com.mihri.FlickrApp.flickrutil;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class Flickr extends FlickrBaseItem {


    public Flickr(String api_key, String format, double lat, double lon) {
        super(api_key, format);
        photoSets = new PhotoSets(api_key, format);
        photoSearchs = new PhotoSearchs(api_key, format, lat, lon);
        photos = new Photos(api_key, format);
    }
    

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    private Photos photos;

    private PhotoSets photoSets;

    public PhotoSets getPhotoSets() {
        return photoSets;
    }

    public void setPhotoSets(PhotoSets photoSets) {
        this.photoSets = photoSets;
    }
    
    private PhotoSearchs photoSearchs;

    public PhotoSearchs getPhotoSearchs() {
        return photoSearchs;
    }

    public void setPhotoSearchs(PhotoSearchs photoSearchs) {
        this.photoSearchs = photoSearchs;
    }
}
