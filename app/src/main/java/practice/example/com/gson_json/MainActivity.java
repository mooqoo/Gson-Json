package practice.example.com.gson_json;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import practice.example.com.gson_json.Model.AlbumImages;
import practice.example.com.gson_json.Model.Albums;
import practice.example.com.gson_json.Model.Dataset;
import practice.example.com.gson_json.Util.JsonUtil;


/**
 * This is a Sample project that use Google's gson library to convert between java object and json.
 * https://github.com/google/gson
 */
public class MainActivity extends Activity {
    public static final String TAG = "Main";

    //Global Variables
    public Albums album = null;
    public String json = "";

    //GSON
    public Gson gson;

    //Use Butter Knife to bind view
    @Bind(R.id.tv_log) TextView tv_log;
    @OnClick({R.id.btn_generate_object, R.id.btn_gson_parse, R.id.btn_gson_tojson, R.id.btn_jsonobject_parse, R.id.btn_jsonobject_tojson, R.id.btn_log_reset})
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_generate_object:
                resetObject();
                break;
            case R.id.btn_gson_tojson:
                gson_toJson();
                break;
            case R.id.btn_gson_parse:
                gson_parseJson();
                break;
            case R.id.btn_jsonobject_tojson:
                jsonObject_toJson();
                break;
            case R.id.btn_jsonobject_parse:
                jsonObject_parseJson();
                break;
            case R.id.btn_log_reset:
                cleanLog();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind view using butterKnife
        ButterKnife.bind(this);

        //set the textview log scroll movement
        tv_log.setMovementMethod(new ScrollingMovementMethod());

        //setup Gson/Gson builder
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        gson = builder.create();
    }

    //-------------------------------------- button method ---------------------------------------//
    private void resetObject() {
        List<Dataset> datasetList = new ArrayList<Dataset>();
        datasetList.add(createDataSet(new ArrayList<AlbumImages>() {{
                                            add(new AlbumImages());
                                            add(new AlbumImages());
                                            add(new AlbumImages());
                                        }}));
        datasetList.add(createDataSet(new ArrayList<AlbumImages>() {{
                                            add(new AlbumImages());
                                            add(new AlbumImages());
                                        }}));
        album = createAlbum(datasetList);
        json = "";
    }

    private void cleanLog() {
        Log.i(TAG,"cleanLog(): tv_log="+tv_log);

        if(tv_log!=null)
            tv_log.setText("Log: \n");
    }

    private void gson_toJson() {
        json = gson.toJson(album);

        //print results
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + "convert object to JSON: using GSON\n JSON: \n" + json +"\n\n");
    }

    private void gson_parseJson() {
        album = gson.fromJson(json, Albums.class);
        //print results
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + "convert JSON to object: using GSON\n" + album +"\n\n");
    }

    private void jsonObject_toJson() {
        json = JsonUtil.toJSON(album);

        //print results
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + "convert object to JSON: using JSONObject\n JSON: \n" + json +"\n\n");
    }

    private void jsonObject_parseJson() {
        album = JsonUtil.fromJSON_toAlbum(json);

        //print results
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + "JSON object to object: using JSONObject\n" + album +"\n\n");
    }

    //--------------------------------------------- Create Data method ---------------------------//
    private Albums createAlbum(List<Dataset> dataset) {
        Random r = new Random();
        Albums albums = new Albums();
        albums.title = "Free Music Archive: " + r.nextInt();
        albums.message = Long.toString(r.nextLong(), 32);   //"";
        albums.dataset = dataset;
        albums.total =  Long.toString(r.nextLong());        //"11259";
        albums.total_pages = r.nextInt();                   //2252;
        albums.page = r.nextInt(5);
        albums.limit = "5";
        if(tv_log!=null)
            tv_log.setText(tv_log.getText() + "createAlbum:" + albums.toString()+"\n");
        Log.i(TAG, albums.toString());

        return albums;
    }

    private Dataset createDataSet(List<AlbumImages> images) {
        Random r = new Random();
        Dataset dataset = new Dataset();
        dataset.album_id = "" + r.nextInt(3000);
        dataset.album_title = "Album " + Long.toString(r.nextLong(), 32);
        dataset.images = images;
        return dataset;
    }
}
