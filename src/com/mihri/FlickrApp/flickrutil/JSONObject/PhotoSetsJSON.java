package com.mihri.FlickrApp.flickrutil.JSONObject;

import com.mihri.FlickrApp.flickrutil.FlickrBaseItem;
import com.mihri.FlickrApp.flickrutil.PhotoSet;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotoSetsJSON extends FlickrBaseItemJSON {
    public PhotoSet getPhotoset() {
        return photoset;
    }

    public void setPhotoset(PhotoSet photoset) {
        this.photoset = photoset;
    }

    private PhotoSet photoset;


}
