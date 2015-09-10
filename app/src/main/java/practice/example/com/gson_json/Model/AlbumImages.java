package practice.example.com.gson_json.Model;

import java.util.Random;

/**
 * Created by mooqoo on 15/7/24.
 */
public class AlbumImages {
    public String image_id;

    //Constructor
    public AlbumImages() {
        image_id = "" + new Random().nextInt();
    }

    public String toString() {
        String msg="";
        msg+="\t\t\timage_id: "        + image_id       + "\n";
        return msg;
    }
}
