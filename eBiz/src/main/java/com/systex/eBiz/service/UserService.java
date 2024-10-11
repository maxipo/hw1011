package com.systex.eBiz.service;

import com.systex.eBiz.model.User;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> userList = new ArrayList<>();

    // 用於密碼加密的函數
    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    // 檢查用戶輸入是否為空
    public boolean validateInput(String loginname, String password) {
        return !(loginname == null || loginname.isEmpty() ||
                 password == null || password.isEmpty());
    }

    // 添加新用戶
    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String loginname, String hashedPassword) {
        for (User user : userList) {
            if (user.getLoginname().equals(loginname) && user.getPassword().equals(hashedPassword)) {
                return user; // 返回匹配的用戶
            }
        }
        return null; // 找不到用戶
    }
}

