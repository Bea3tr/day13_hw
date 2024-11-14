package ssf.day13_hw.models;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class IndexController {

    // Get field inputs from index.html form & store in User
    @GetMapping(path={"/", "index.html"})
    public String getIndex(Model model) {
        
        model.addAttribute("user", new User());
        
        return "index";
    }

    // Prevent unauthenticated access before login
    @GetMapping("/secret.html")
    public String getSecret(Model model) {

        model.addAttribute("user", new User());

        return "index";
    }

    @PostMapping("/")
    public String postLogout(HttpSession sess, Model model) {
        sess.invalidate();
        model.addAttribute("user", new User());
        return "index";
    }
    
}
