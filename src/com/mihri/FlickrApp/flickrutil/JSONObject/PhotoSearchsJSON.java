package com.mihri.FlickrApp.flickrutil.JSONObject;

import com.mihri.FlickrApp.flickrutil.FlickrBaseItem;
import com.mihri.FlickrApp.flickrutil.PhotoSearch;
import com.mihri.FlickrApp.flickrutil.PhotoSet;

/**
 * Created by Mihri Minaz on 12/03/14.
 */
public class PhotoSearchsJSON extends FlickrBaseItemJSON {
	    public PhotoSearch getPhotoSearch() {
	        return photos;
	    }

	    public void setPhotoSearch(PhotoSearch photos) {
	        this.photos = photos;
	    }

	    private PhotoSearch photos;
}