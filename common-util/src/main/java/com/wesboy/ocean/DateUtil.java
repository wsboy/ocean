package com.wesboy.ocean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wangpengbo
 * @date: 2018/2/8
 */
public class DateUtil {

    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

}
