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

    public String toString() {
        String msg="\tdataset: \n";
        msg+="\t\talbum_id: "        + album_id       + "\n";
        msg+="\t\talbum_title: "     + album_title    + "\n";
        msg+="\t\timages: \n";
        for(AlbumImages image: images)
            msg+= image.toString();
        return msg;
    }
}
