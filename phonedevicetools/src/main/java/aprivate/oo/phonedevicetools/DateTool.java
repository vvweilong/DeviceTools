package aprivate.oo.phonedevicetools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuxiaolong on 16/7/4.
 */
public class DateTool {

    public static String getLocalDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy MM dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }


    public static Date getLabLocalDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        return curDate;
    }


}
