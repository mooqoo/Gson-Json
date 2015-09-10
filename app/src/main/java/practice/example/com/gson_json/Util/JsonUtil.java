package practice.example.com.gson_json.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import practice.example.com.gson_json.Model.AlbumImages;
import practice.example.com.gson_json.Model.Albums;
import practice.example.com.gson_json.Model.Dataset;

/**
 * Created by mooqoo on 15/9/10.
 */
public class JsonUtil {

    public static String toJSON(Albums album) {
        try {
            //Creating JSONObject for album
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("title", album.title);
            jsonObj.put("message", album.message);
            jsonObj.put("total", album.total);
            jsonObj.put("total_pages", album.total_pages);
            jsonObj.put("page", album.page);
            jsonObj.put("limit", album.limit);

            //convert dataset into JSONArray
            JSONArray jsonArray = new JSONArray();
            for(Dataset dataset:album.dataset)
                jsonArray.put(toJSONObject(dataset));

            //put JSONArray into JsonObject
            jsonObj.put("dataset", jsonArray);

            return jsonObj.toString();
        } catch(JSONException ex) {

        }
        return null;
    }


    //Create JSONObject for dataset
    public static JSONObject toJSONObject(Dataset dataset) {
        try {
            //Creating JSONObject for album
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("album_id", dataset.album_id);
            jsonObj.put("album_title", dataset.album_title);
            //convert datasetImages into JSONArray
            JSONArray jsonArray = new JSONArray();
            for(AlbumImages albumImage:dataset.images)
                jsonArray.put(toJSONObject(albumImage));
            //put JSONArray into JsonObject
            jsonObj.put("images", jsonArray);
            return jsonObj;
        } catch(JSONException ex) {

        }
        return null;
    }

    //Create JSONObject for albumImages
    public static JSONObject toJSONObject(AlbumImages albumImages) {
        try {
            //Creating JSONObject for album
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("image_id", albumImages.image_id);
            return jsonObj;
        } catch(JSONException ex) {

        }
        return null;
    }

    //------------------------- Parse -----------------------------------
    public static Albums fromJSON_toAlbum(String json) {
        try {
            Albums albums = new Albums();
            JSONObject jsonObject = new JSONObject(json);
            albums.title = jsonObject.getString("title");
            albums.message = jsonObject.getString("message");
            albums.total = jsonObject.getString("total");
            albums.total_pages = jsonObject.getInt("total_pages");
            albums.page = jsonObject.getInt("page");
            albums.limit = jsonObject.getString("limit");

            JSONArray jsonArray = jsonObject.getJSONArray("dataset");
            List<Dataset> dataset = new ArrayList<Dataset>();
            for(int i=0; i<jsonArray.length(); i++)
                dataset.add(fromJSON_toDataset(jsonArray.getJSONObject(i).toString()));
            albums.dataset = dataset;
            return albums;
        } catch(JSONException ex) {

        }
        return null;
    }

    public static Dataset fromJSON_toDataset(String json) {
        try {
            Dataset dataset = new Dataset();
            JSONObject jsonObject = new JSONObject(json);
            dataset.album_id = jsonObject.getString("album_id");
            dataset.album_title = jsonObject.getString("album_title");


            JSONArray jsonArray = jsonObject.getJSONArray("images");
            List<AlbumImages> images = new ArrayList<AlbumImages>();
            for(int i=0; i<jsonArray.length(); i++)
                images.add(fromJSON_toAlbumImages(jsonArray.getJSONObject(i).toString()));
            dataset.images = images;

            return dataset;
        } catch(JSONException ex) {

        }
        return null;
    }

    public static AlbumImages fromJSON_toAlbumImages(String json) {
        try {
            AlbumImages albumImages = new AlbumImages();
            JSONObject jsonObject = new JSONObject(json);
            albumImages.image_id = jsonObject.getString("image_id");
            return albumImages;
        } catch(JSONException ex) {

        }
        return null;
    }
}
