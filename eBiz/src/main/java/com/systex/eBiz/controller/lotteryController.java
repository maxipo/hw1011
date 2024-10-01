package com.systex.eBiz.controller;

import com.systex.eBiz.service.LotteryService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping
//@WebServlet(name = "lotteryController", value = "/Lottery/lotteryController")
public class lotteryController {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/main")
    public String showForm() {
        return "main";  // 返回 main.jsp
    }

    @GetMapping("/index")
    public String showHomePage() {
        return "../../index";  // 返回 index.jsp
    }

    @PostMapping("/lotteryController")
    public String drawLottery(@RequestParam("group") int group, @RequestParam("exclude") String exclude, Model model) {
        // Retrieve Form Data
        String[] excludes = exclude.split(" ");
        ArrayList[] arrayLists = lotteryService.getNumbers(group, excludes);
        System.out.println("get method called");
        model.addAttribute("numbers", arrayLists);
        return "result";
    }
}


/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher view;
//        System.out.println("hello servlet");
//        PrintWriter out = response.getWriter();
//        view = request.getRequestDispatcher("result.jsp");
//        view.forward(request, response);
        // 1. Retrieve Form Data
        int group = Integer.parseInt(request.getParameter("group"));
        String excludeString = request.getParameter("exclude");
        // Convert Form Data
        String[] excludes = excludeString.split(" ");
        LinkedList<Integer> excludeNumbers = new LinkedList<>();
        for (String exclude : excludes) {
            excludeNumbers.add(Integer.parseInt(exclude));
        }
        // Invoke Business Logic
        LotteryService lotteryService = new LotteryService();
        ArrayList[] arrayLists = lotteryService.getNumbers(group, excludeNumbers);
        request.setAttribute("numbers", arrayLists); // Request-Scope
        view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
*/
