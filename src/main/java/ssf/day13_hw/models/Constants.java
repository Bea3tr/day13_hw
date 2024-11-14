package ssf.day13_hw.models;

import java.io.File;
import java.util.*;
import java.security.SecureRandom;
import jakarta.servlet.http.HttpSession;


public class Constants {

    public static final String USER_LIST = "userList";
    public static final String PASSWORD = "password";
    public static String CAPTCHA = "";

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
        Random rand = new SecureRandom();
        File folder = new File("C:/Users/Beatrice/Documents/VISA/SSF13/day13_hw/src/main/resources/static/captcha");
        File[] files = folder.listFiles();
        int idx = rand.nextInt(files.length);
        CAPTCHA = files[idx].getName().split("\\.")[0];
        System.out.println("Captcha: " + CAPTCHA);
        return files[idx].getName();
    }
}
