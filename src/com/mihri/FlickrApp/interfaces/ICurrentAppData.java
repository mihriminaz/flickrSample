package  com.mihri.FlickrApp.interfaces;

import android.graphics.Bitmap;
import com.google.inject.Singleton;
import com.mihri.FlickrApp.vo.ImageInfo;

import java.util.List;

/**
 * Created by ServusKevin on 12/18/13.
 */
public interface ICurrentAppData {
    List<ImageInfo> getImageInfos();

    void setImageInfos(List<ImageInfo> imageInfos);

    int getCurrentPosition();

    void setCurrentPosition(int currentPosition);
}
