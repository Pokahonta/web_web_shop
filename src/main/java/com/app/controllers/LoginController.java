package com.app.controllers;

import com.app.model.Login;
import com.app.model.User;
import com.app.services.LangService;
import com.app.services.LoginService;
import com.app.services.UserService;
import com.app.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    CurrentUser currentUser;

    @Autowired
    private LangService langService;


    @GetMapping("/logout_old")
    public String logoutUser(HttpSession session) {
        if (currentUser.getId() !=null){
            session.invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping ("/login")
    public String getLoginForm(Model model) {
        if (currentUser.getId() !=null){
            model.addAttribute("id", currentUser.getId());
            return "login_response";
        }
        model.addAttribute("login", new Login());
        return "login";
    }


    @GetMapping("/translations")
    public String getTranslationsPage(Model model) {
        if (currentUser.getLangId() == null) {
            currentUser.setLangId(1);
        }
        model.addAttribute("lang", langService.getTranslations(currentUser.getLangId(), "homePage"));
        return "translations";
    }


    @GetMapping("/setLang/{langId}")
    @ResponseBody
    public void setLang(@PathVariable(value = "langId") int langId) {
        currentUser.setLangId(langId);

    }


    @PostMapping("/login")
    public String loginUser(@ModelAttribute Login loginObject, Model model) {
        Integer userId = loginService.getUserId(loginObject);
        if (userId != null) {
            currentUser.setId(userId);
            currentUser.setName(loginObject.getEmail());
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