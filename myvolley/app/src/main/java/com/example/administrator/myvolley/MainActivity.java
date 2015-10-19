package com.example.administrator.myvolley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

  //  private ImageView iv1;
    private NetworkImageView iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (NetworkImageView) findViewById(R.id.iv2);


        //返回string
        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.baidu.com", new Response.Listener<java.lang.String>() {
//            @Override
//            public void onResponse(String s) {
//                Toast.makeText(MainActivity.this, s, 1).show();
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(MainActivity.this, volleyError.getMessage(), 1).show();
//            }
//        });
//        queue.add(stringRequest);

//        final LruCache<String,Bitmap> lurcache = new LruCache<>(20);
//        ImageLoader.ImageCache cache = new ImageLoader.ImageCache() {
//            @Override
//            public Bitmap getBitmap(String s) {
//                return lurcache.get(s);
//            }
//
//            @Override
//            public void putBitmap(String s, Bitmap bitmap) {
//                lurcache.put(s,bitmap);
//            }
//        };
//        ImageLoader loader = new ImageLoader(queue,cache);
//        ImageLoader.ImageListener listner =  loader.getImageListener(iv1, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
//        loader.get("http://pic.nipic.com/2007-11-09/200711912230489_2.jpg", listner);







        //返回string
//        queue = Volley.newRequestQueue(this);
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                "http://www.baidu.com",null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject s) {
//                Toast.makeText(MainActivity.this, s.toString(), 1).show();
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Toast.makeText(MainActivity.this, volleyError.getMessage(), 1).show();
//            }
//        });
//        queue.add(stringRequest);




        final LruCache<String,Bitmap> lurcache = new LruCache<>(20);
        ImageLoader.ImageCache cache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return lurcache.get(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {
                lurcache.put(s,bitmap);
            }
        };
        ImageLoader loader = new ImageLoader(queue,cache);
        iv2.setTag("url");
        iv2.setImageUrl("http://pic.nipic.com/2007-11-09/200711912230489_2.jpg",loader);






    }
}
