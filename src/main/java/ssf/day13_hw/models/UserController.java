package ssf.day13_hw.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        BindingResult bindings,
        HttpSession sess) {

            if(bindings.hasErrors())
                return "index";

            // Check if session has the list
            List<User> userList = getList(sess);
            userList.add(user);

            // Check correct password
            if (!user.getPassword().equals(PASSWORD) && userList.size() > 2) {
                String captcha = "/captcha/" + generateCaptcha();
                model.addAttribute("user", new User());
                model.addAttribute("captcha", captcha);
                return "unsuccessful";
            }
            else if (user.getPassword().equals(PASSWORD)) {
                String secret = "/images/" + generateSecret();
                model.addAttribute("secret", secret);
                return "secret";
            }
                
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
