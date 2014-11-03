package com.mihri.FlickrApp.flickrutil.JSONObject;

import com.mihri.FlickrApp.flickrutil.Sizes;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class PhotosJSON extends FlickrBaseItemJSON {
    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    private Sizes sizes;
}
