package practice.example.com.gson_json.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mooqoo on 15/7/24.
 */
public class Albums {
    public String title;
    public String message;
    public String total;
    public int total_pages;
    public int page;
    public String limit;
    public List<Dataset> dataset  = new ArrayList<Dataset>();

    public String toString() {
        String msg="\nAlbum: \n";
        msg+="\ttitle: "          + title         + "\n";
        msg+="\tmessage: "        + message       + "\n";
        msg+="\ttotal: "          + total         + "\n";
        msg+="\ttotal_pages: "    + total_pages   + "\n";
        msg+="\tpage: "           + page          + "\n";
        msg+="\tlimit: "          + limit         + "\n";
        for(Dataset data: dataset)
            msg+= data.toString();
        return msg;
    }

}
