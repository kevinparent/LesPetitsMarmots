package com.kp.lespetitsmarmots.helper.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kevin on 2016-01-19.
 */
public class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {
    ImageView bmImage;
    Context ctx;
    ProgressDialog progressDialog;
    String url;

    public DownloadImageTask(ImageView bmImage, String url) {
        this.bmImage = bmImage;
        this.url = url;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        String urldisplay = this.url;
        Log.d("URLDISPLAY = ", "URL = " + urldisplay);
        Bitmap mIcon11;
        try {
            URL url = new URL(urldisplay);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream in = connection.getInputStream();
            mIcon11 = BitmapFactory.decodeStream(in);

            return mIcon11;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        bmImage.setImageBitmap(result);

    }


}