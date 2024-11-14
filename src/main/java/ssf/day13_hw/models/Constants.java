package ssf.day13_hw.models;

import java.util.*;
import jakarta.servlet.http.HttpSession;


public class Constants {

    public static final String USER_LIST = "userList";
    public static final String PASSWORD = "password";
    public static final String CAPTCHA = "qGphJD";

    public static List<User> getList(HttpSession sess) {

        List<User> userList = (List<User>) sess.getAttribute(USER_LIST);
        if (userList == null) {
            userList = new LinkedList<>();
            sess.setAttribute(USER_LIST, userList);
        }
        return userList;
    }
    
}
