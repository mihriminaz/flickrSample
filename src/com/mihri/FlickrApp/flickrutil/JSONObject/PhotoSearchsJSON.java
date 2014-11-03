package com.mihri.FlickrApp.flickrutil.JSONObject;

import com.mihri.FlickrApp.flickrutil.FlickrBaseItem;
import com.mihri.FlickrApp.flickrutil.PhotoSearch;
import com.mihri.FlickrApp.flickrutil.PhotoSet;

/**
 * Created by Mihri Minaz on 12/03/14.
 */
public class PhotoSearchsJSON extends FlickrBaseItemJSON {
	    public PhotoSearch getPhotoSearch() {
	        return photoSearch;
	    }

	    public void setPhotoSearch(PhotoSearch photoSearch) {
	        this.photoSearch = photoSearch;
	    }

	    private PhotoSearch photoSearch;
}