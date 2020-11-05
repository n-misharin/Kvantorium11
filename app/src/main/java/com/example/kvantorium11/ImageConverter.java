package com.example.kvantorium11;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class ImageConverter {

    private int width, height;
    private Bitmap bitmap;

    public ImageConverter(Bitmap bitmap, int newWidth, int newHeight){
        this.bitmap = bitmap;
        this.height = newHeight;
        this.width = newWidth;
    }

    public ImageConverter(Resources resources, int id, int newWidth, int newHeight){
        this(BitmapFactory.decodeResource(resources, id), newWidth, newHeight);
    }

    public ImageConverter(Resources resources, int logo1, int width) {
    }

    public Bitmap convert(){
        double newRelation = 1.0 * width / height;
        double oldRelation = 1.0 * bitmap.getWidth() / bitmap.getHeight();

        int newWidth;
        int newHeight;

//        Log.i(AuthorizationActivity.TAG, "relation   " + newRelation + " " + oldRelation);
//        Log.i(AuthorizationActivity.TAG, "bitmap     " + bitmap.getWidth() + " " + bitmap.getHeight());

        if(newRelation < oldRelation){
            newHeight = bitmap.getHeight();
            newWidth = (int) (bitmap.getHeight() * newRelation);
        }else{
            newHeight = (int) (bitmap.getWidth() / newRelation);
            newWidth = bitmap.getWidth();
        }

//        Log.i(AuthorizationActivity.TAG, "new values    " + newWidth + " " + newHeight);
//        Log.i(AuthorizationActivity.TAG, "new relation  " + 1.0 * newWidth / newHeight);
//        Log.i(AuthorizationActivity.TAG, "screen values " + width + " " + height);

        int deltaWidth  = bitmap.getWidth()  - newWidth;
        int deltaHeight = bitmap.getHeight() - newHeight;

        return Bitmap.createBitmap(bitmap, deltaWidth / 2,  deltaHeight / 2, newWidth, newHeight);
        //return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }
}
