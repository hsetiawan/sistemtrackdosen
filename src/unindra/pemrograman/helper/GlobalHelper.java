package unindra.pemrograman.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalHelper {

    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
    public String dateToString(){
        return sdf.format(new Date());
    }

    public String red(String values){
        return "\\033[31m"+values+"\\033[32m";
    }


}
