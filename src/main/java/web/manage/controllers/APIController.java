package web.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.manage.entities.Account;
import web.manage.services.AccountService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/api")
public class APIController {

    @Autowired
    private AccountService service;
    @PostMapping(path="/login/account")
    public @ResponseBody Object loginAccount(@RequestBody LinkedHashMap<String,String> body, HttpServletResponse response) {
        String userName = body.get("userName");
        String password = body.get("password");
        Map<String, String> json = new LinkedHashMap<>();
        json.put("type", body.get("type"));
        Account account = service.getUser(userName, password);
        if(account != null) {
            json.put("status", "ok");
            json.put("currentAuthority",account.getPower());
            Cookie cookie = new Cookie("userName", userName);
            cookie.setMaxAge(300 * 60);// 设置为30min
            cookie.setPath("/");
            System.out.println("已添加===============");
            response.addCookie(cookie);

        }else {
            json.put("status", "error");
            json.put("currentAuthority","guest");
        }

        return json;
    }

    @GetMapping(path="/currentUser")
    public @ResponseBody Object currentUser(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        Map<String, String> json = new LinkedHashMap<>();
        if (null==cookies) {
            System.out.println("没有cookie=========");
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("userName")){
                    String name = cookie.getValue();
                    Account account = service.getUser(name);
                    if(account != null){
                        json.put("name",name);
                        json.put("userid",account.getId().toString());
                        json.put("avatar","");
                    }

                }

            }
        }


        return json;
    }

    @GetMapping(path="/403")
    public @ResponseBody Object Error403(HttpServletResponse response) {
        Map<String, String> json = new LinkedHashMap<>();

        response.setStatus(403);
        return json;
    }
}
