package com.mihri.FlickrApp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridView;
import com.mihri.FlickrApp.adapters.ImageGridViewAdapter;
import com.mihri.FlickrApp.constants.ConstantValues;
import com.mihri.FlickrApp.flickrutil.Flickr;
import com.mihri.FlickrApp.flickrutil.Photo;
import com.mihri.FlickrApp.flickrutil.Size;
import com.mihri.FlickrApp.interfaces.ICurrentAppData;
import com.mihri.FlickrApp.vo.ImageInfo;
import com.hintdesk.core.utils.DeviceUtil;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends RoboActivity {
    @InjectView(R.id.gridView)
    private GridView gridView;
    @Inject
    ICurrentAppData currentAppData;
    private ImageGridViewAdapter imageGridViewAdapter;
    protected LocationManager locationManager;
    private Location lastLocation;

    String context = Context.LOCATION_SERVICE;
   
    
    
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // fyl lfyl = new fyl(this); //Here the context is passing 

       // lastLocation = lfyl.getLocation();
       
        setContentView(R.layout.main);
        initializeComponents();
        new LoadImagesFromFlickrTask().execute();
        
  }


    
    private void initializeComponents() {
        float spacing = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                ConstantValues.GRIDVIEW_SPACING, getResources().getDisplayMetrics());
        gridView.setNumColumns(DeviceUtil.getDeviceDimensions(MainActivity.this).x / ConstantValues.GRIDVIEW_COLUMN_WIDTH);
        gridView.setPadding((int) spacing, (int) spacing, (int) spacing, (int) spacing);
        gridView.setVerticalSpacing((int) spacing);
        gridView.setHorizontalSpacing((int) spacing);
    }

    class LoadImagesFromFlickrTask extends AsyncTask<String, Integer, List<ImageInfo>> {
        private ProgressDialog progressDialog;
        private Integer totalCount, currentIndex;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading images from Flickr. Please wait...");
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setMessage(String.format("Loading images from Flickr %s/%s. Please wait...", values[0], values[1]));
        }

        @Override
        protected List<ImageInfo> doInBackground(String... params) {
            Flickr flickr = new Flickr(ConstantValues.FLICKR_API_KEY, ConstantValues.FLICKR_FORMAT, 0,0);
            List<Photo> photos = flickr.getPhotoSearchs().getPhotos();
          
            List<ImageInfo> result = new ArrayList<ImageInfo>();
            totalCount = photos.size();
            currentIndex = 0;
            for (Photo photo : photos) {
                currentIndex++;
                List<Size> sizes = flickr.getPhotos().getSizes(photo.getId());
                String thumbnailUrl = sizes.get(0).getSource();
                String mediumUrl = sizes.get(4).getSource();
                InputStream inputStreamThumbnail = null, inputStreamMedium = null;
                /*try {
                  inputStreamThumbnail = new URL(thumbnailUrl).openStream();
                    inputStreamMedium = new URL(mediumUrl).openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                Bitmap bitmapThumbnail = BitmapFactory.decodeStream(inputStreamThumbnail);
                Bitmap bitmapMedium = BitmapFactory.decodeStream(inputStreamMedium);
                result.add(new ImageInfo(photo.getTitle(), bitmapThumbnail, bitmapMedium));
                publishProgress(currentIndex, totalCount);
//                if (currentIndex>3)
//                    break;
            }
            currentAppData.setImageInfos(result);
            return result;
        }

        @Override
        protected void onPostExecute(List<ImageInfo> s) {
            progressDialog.dismiss();
            imageGridViewAdapter = new ImageGridViewAdapter(MainActivity.this);
            gridView.setAdapter(imageGridViewAdapter);
            super.onPostExecute(s);
        }
    }
public class fyl {
       	 Context mContext;
       	 public fyl(Context mContext){
       	       this.mContext = mContext;
       	  }

       	  public Location getLocation(){
       	   locationManager = (LocationManager)mContext.getSystemService(context);
       	   return locationManager.getLastKnownLocation(context);
       	  }
     }
}
    

