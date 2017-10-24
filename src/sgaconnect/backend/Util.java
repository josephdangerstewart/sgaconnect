/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgaconnect.backend;

import java.util.Calendar;

/**
 *
 * @author josephstewart
 */
public class Util {
    
    public static String getDateFromMili(long mili) {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(mili);
        
        return date.get(Calendar.MONTH) + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR) + " at " + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + " " + (date.get(Calendar.AM_PM)==Calendar.AM ? "am" : "pm");
    }
    
}
