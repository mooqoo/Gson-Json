package practice.example.com.gson_json;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import practice.example.com.gson_json.Model.AlbumImages;
import practice.example.com.gson_json.Model.Albums;
import practice.example.com.gson_json.Model.Dataset;


/**
 * This is a Sample project that use Google's gson library to convert between java object and json.
 * https://github.com/google/gson
 *
 * I follow the example from
 * http://www.studytrails.com/java/json/java-google-json-parse-json-to-java.jsp
 *
 * In this project, I set up the Gson builder
 * Then I created several model classes
 * Then I convert them into Json
 * Then I convert the json back to java object
 *
 */
public class MainActivity extends Activity {
    public static final String TAG = "Json";
    public Gson gson;

    @Bind(R.id.tv_log)
    TextView tv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv_log.setMovementMethod(new ScrollingMovementMethod());

        //setup Gson/Gson builder
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        gson = builder.create();

        //create albums/dataset/images
        Albums albums = createAlbum();
        Dataset dataset = createDataSet();
        dataset.images.add(createAlbumImage());
        albums.dataset.add(dataset);

        //print results
        String json_string = gson.toJson(albums);
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + json_string +"\n");
        Log.i(TAG, json_string);

        //convert json back to Albums using gson
        albums = convertBackToAlbums(json_string);
        //convert object back to json and print it
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + "convert back to object: " + gson.toJson(albums) +"\n");

        //convert json to object using JSONObject
        /*
        try {
            JSONObject jsonObject = new JSONObject(TESTJSON).getJSONObject("coupon");
            if(tv_log!=null)
                tv_log.setText(tv_log.getText() + "jsonObject: \n" + jsonObject.toString(4) +"\n");
            Coupon coupon = Coupon.fromJson(jsonObject);
            if(tv_log!=null && coupon!=null)
                tv_log.setText(tv_log.getText() + "\nTest Coupon: \n" + coupon.toString() +"\n");
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        */

    }


    private Albums createAlbum() {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";


        String json_string = gson.toJson(albums);

        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + json_string+"\n");
        Log.i(TAG, json_string);

        return albums;
    }

    private Dataset createDataSet() {
        Dataset dataset = new Dataset();
        dataset.album_id = "7596";
        dataset.album_title = "Album 1";

        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + gson.toJson(dataset)+"\n");
        Log.i(TAG, gson.toJson(dataset));

        return dataset;
    }

    private AlbumImages createAlbumImage() {
        AlbumImages image = new AlbumImages();
        image.image_id = "1";

        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + gson.toJson(image)+"\n");
        Log.i(TAG, gson.toJson(image));

        return image;
    }

    private Albums convertBackToAlbums(String json_string) {
        return gson.fromJson(json_string, Albums.class);
    }
}
