package com.mihri.FlickrApp.flickrutil;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class FlickrBaseItem {
    protected String api_key;
    protected String format;
    protected String per_page;
    protected String lat;
    protected String lon;

    public FlickrBaseItem() {
        api_key = null;
        format = null;
        per_page = null;
        lat = null;
        lon = null;
    }

    public FlickrBaseItem(String api_key, String format) {
        this.api_key = api_key;
        this.format = format;
        this.per_page = "5";
        this.lat = "30";
        this.lon = "40";
    }
}
