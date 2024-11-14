package ssf.day13_hw.models;

import java.io.File;
import java.util.*;
import java.security.SecureRandom;
import jakarta.servlet.http.HttpSession;


public class Constants {

    public static final String USER_LIST = "userList";
    public static final String PASSWORD = "password";
    public static String CAPTCHA = "";
    public static String SECRET = "";

    private static Random rand = new SecureRandom();

    public static List<User> getList(HttpSession sess) {

        List<User> userList = (List<User>) sess.getAttribute(USER_LIST);
        if (userList == null) {
            userList = new LinkedList<>();
            sess.setAttribute(USER_LIST, userList);
        }
        return userList;
    }
    
    // Return random captcha filename
    public static String generateCaptcha() {
        return getImgName("C:/Users/Beatrice/Documents/VISA/SSF13/day13_hw/src/main/resources/static/captcha", true);
    }

    public static String generateSecret() {
        return getImgName("C:/Users/Beatrice/Documents/VISA/SSF13/day13_hw/src/main/resources/static/images", false);
    }

    private static String getImgName(String filePath, boolean isCaptcha) {
        File folder = new File(filePath);
        File[] files = folder.listFiles();
        int idx = rand.nextInt(files.length);
        if(isCaptcha)
            CAPTCHA = files[idx].getName().split("\\.")[0];
        else
            SECRET = files[idx].getName().split("\\.")[0];

        return files[idx].getName();
    }
}
