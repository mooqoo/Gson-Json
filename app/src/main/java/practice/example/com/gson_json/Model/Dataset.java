package practice.example.com.gson_json.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mooqoo on 15/7/24.
 */
public class Dataset {
    public String album_id;
    public String album_title;
    public List<AlbumImages> images = new ArrayList<AlbumImages>();
}
