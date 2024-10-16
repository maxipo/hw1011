package com.systex.eBiz.controller;

import com.systex.eBiz.model.User;
import com.systex.eBiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
//    private static List<User> userList;

//    public UserController() {
//        this.userList = new ArrayList<>();
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm() {
        return "/registerForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "/loginForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("loginname") String loginname, @RequestParam("username") String username,
                           @RequestParam("password") String password) {
        User user = new User();
        user.setLoginname(loginname);
        user.setUsername(username);
        user.setPassword(userService.hashPassword(password));
        userService.addUser(user);

        return "redirect:/user/login";

    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("loginname") String loginname,

                        @RequestParam("password") String password, Model model, HttpSession session) {
        String hashedPassword = userService.hashPassword(password);
        User user = userService.getUser(loginname, hashedPassword);
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return "success";
        }
        System.out.println("hi it's me");
        return "failure";
//        String hashedPassword = hashPassword(password);
//        for (User user : userList) {
//            if (user.getLoginname().equals(loginname) &&
//                    user.getPassword().equals(hashedPassword)) {
//                session.setAttribute("user", user);  // 登入成功後將 user 資訊存入 session
//                model.addAttribute("user", user);
//                return "success";
//            }
//        }
//        return "failure";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();  // 銷毀 session
        return "redirect:/user/register";  // 導向回註冊頁面
    }
}


