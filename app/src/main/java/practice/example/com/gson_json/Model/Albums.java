package practice.example.com.gson_json.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wade0716 on 15/7/24.
 */
public class Albums {
    public String title;
    public String message;
    //public String[] errors = new String[]{};
    public List<String> errors = new ArrayList<String>();
    public String total;
    public int total_pages;
    public int page;
    public String limit;
    public List<Dataset> dataset  = new ArrayList<Dataset>();

}
