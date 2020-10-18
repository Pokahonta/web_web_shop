package com.app.controllers;

import com.app.model.Login;
import com.app.model.User;
import com.app.services.LoginService;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping ("/login")
    public String getLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute Login login, Model model){
        Integer userId = loginService.getUserId(login);
        if (userId != null){
            model.addAttribute("id", userId);
            return "login_response";
        }
        return "login";

    }


//   @Autowired
//    private UserService userService;
//    @GetMapping("/login")
//   public String getLoginPage(Model model){
//       model.addAttribute("user", new User());
//       return "login";
//
//    }
//
//   @PostMapping("/login")
//  public String login(@ModelAttribute User user, Model model){
//        List<User> users = userService.getUserByPasswordAndLogin(user);
//        Boolean exists = !CollectionUtils.isEmpty(users);
//      model.addAttribute("exists", exists);
//      return "loginSuccess";
//    }

}