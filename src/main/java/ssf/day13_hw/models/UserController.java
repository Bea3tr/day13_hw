package ssf.day13_hw.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import static ssf.day13_hw.models.Constants.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public String postUser(Model model,
        @ModelAttribute User user,
        HttpSession sess) {

            // Check if session has the list
            List<User> userList = getList(sess);
            userList.add(user);

            // Check correct password
            if (!user.getPassword().equals(PASSWORD) && userList.size() > 2) {
                model.addAttribute("user", new User());
                return "unsuccessful";
            }
            else if (user.getPassword().equals(PASSWORD))
                return "secret";

            model.addAttribute("user", user);
            model.addAttribute(USER_LIST, userList);

            return "index";
        }

    @PostMapping("/captcha")
    public String postCaptcha(Model model,
        @ModelAttribute User user) {

            if(!user.getPassword().equals(PASSWORD) || !user.getCaptcha().equals(CAPTCHA))
                return "fail";
            
            return "secret";
    }
    
}
