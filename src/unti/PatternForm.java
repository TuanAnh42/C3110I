/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unti;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import unti.Validate;

import java.util.regex.Pattern;

/**
 *
 * @author AD
 */
public class PatternForm {
    public static boolean GetName(String str){
        Pattern p = Pattern.compile("^[A-Za-z\\s]+$");
        boolean match = p.matcher(str).matches();
        return match;      
    }
    public static boolean GetEmail(String str){
        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        boolean match = p.matcher(str).matches();
        return match;      
    }
    public static boolean GetMobile(String str){
        boolean match = Pattern.compile("^0[\\d]{9}").matcher(str).matches();
        return match;      
    }
//    public static boolean GetPassword(String str){
//        Pattern p = Pattern.compile("^[A-Za-z\\S]+$");
//        boolean match = p.matcher(str).matches();
//        return match;      
//    }
    public static boolean GetAddress(String str){
        Pattern p = Pattern.compile("[A-Za-z]+");
        boolean match = p.matcher(str).matches();
        return match;
        
    }
//    public static boolean GetPass(String str){
//        Pattern p = Pattern.compile("^(?=.{6,})(?=.*[a-z]\\S)$");
//        boolean match = p.matcher(str).matches();
//        return match;
//        
//    }
    public static String GettransFormVN(float x){      
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat VN = NumberFormat.getCurrencyInstance(localeVn);
        String str1 = VN.format(x);
        return str1;
        
    }
   
    
    public static String getTimeNow(String pattern) {    // Lấy ngày lẫn giờ hiện tại
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
     
     public static LocalTime getTimeNow() {
        return java.time.LocalTime.now();
    }
}
