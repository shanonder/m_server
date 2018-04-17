package web.manage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.manage.entities.Account;
import web.manage.services.AccountService;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(path="/api/member")
public class MemberController {

    @Autowired
    private AccountService service;

    @PostMapping(path="/add")
    public  @ResponseBody Object add(@RequestBody LinkedHashMap<String,String> body){
        Map<String, String> json = new LinkedHashMap<>();
        String password = body.get("password");
        String userName = body.get("userName");
        String power = body.get("power");
        if(service.getUser(userName) != null){
            json.put("status", "error");
            json.put("message", "用户名已存在");
        }else{
            Account account = new Account();
            account.setPassword(password);
            account.setUserName(userName);
            account.setPower(power);
            service.save(account);
            json.put("status", "ok");

        }
        return json;
    }

    @PostMapping(path="/set_password")
    public  @ResponseBody Object setPassword(@RequestBody LinkedHashMap<String,String> body){
        Map<String, String> json = new LinkedHashMap<>();
        String userName = body.get("userName");
        String passOld = body.get("passOld");
        Account account = service.getUser(userName,passOld);
        if(account == null){
            json.put("status", "error");
            json.put("message", "用户名密码错误");
            return json;
        }
        String passNew = body.get("passNew");
        if(passNew == null || passNew.equals("")){
            json.put("status", "error");
            json.put("message", "新密码不能为空");
            return json;
        }
        account.setPassword(passNew);
        json.put("status", "ok");
        return json;
    }

    @PostMapping(path="/set_power")
    public  @ResponseBody Object setPower(@RequestBody LinkedHashMap<String,String> body){
        Map<String, String> json = new LinkedHashMap<>();
        String userName = body.get("userName");
        Account account = service.getUser(userName);
        if(account == null){
            json.put("status", "error");
            json.put("message", "用户不存在");
            return json;
        }
        String password = body.get("password");
        String power = body.get("power");
        if(!password.equals("")){
            account.setPassword(password);
        }

        if(!power.equals("")){
            account.setPower(power);
        }
        service.save(account);
        json.put("status", "ok");
        return json;
    }
}
