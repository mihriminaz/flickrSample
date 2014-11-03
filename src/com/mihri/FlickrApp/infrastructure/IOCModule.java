package com.mihri.FlickrApp.infrastructure;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.mihri.FlickrApp.implementations.CurrentAppData;
import com.mihri.FlickrApp.interfaces.ICurrentAppData;

/**
 * Created by ServusKevin on 12/15/13.
 */
public class IOCModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(ICurrentAppData.class).to(CurrentAppData.class);
    }
}
