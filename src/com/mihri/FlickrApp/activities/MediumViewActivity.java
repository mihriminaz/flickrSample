package com.mihri.FlickrApp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewParent;
import com.mihri.FlickrApp.R;
import com.mihri.FlickrApp.adapters.MediumViewAdapter;
import com.mihri.FlickrApp.constants.ConstantValues;
import com.mihri.FlickrApp.interfaces.ICurrentAppData;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import javax.inject.Inject;

/**
 * Created by ServusKevin on 12/16/13.
 */
public class MediumViewActivity extends RoboActivity {
    @InjectView(R.id.pager)
    private ViewPager viewPager;
    @Inject
    ICurrentAppData currentAppData;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_view);

        MediumViewAdapter mediumViewAdapter = new MediumViewAdapter(MediumViewActivity.this);
        viewPager.setAdapter(mediumViewAdapter);
        viewPager.setCurrentItem(currentAppData.getCurrentPosition());
    }
}