package web.manage.services;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.manage.entities.Account;
import web.manage.repositories.AccountRepository;


@Service
public class AccountService {
	
	@Autowired 
	private AccountRepository userRepository;
	public Account getUser(String userName,String password) {
		Account user = userRepository.findByUserNameAndPassword(userName, password);
		return user;
	}

	public Account getUser(String userName) {
		Account user = userRepository.findByUserName(userName);
		return user;
	}

	public Account save(Account account){
		return userRepository.save(account);
	}

	public String findAll(){
		Iterable<Account> accounts = userRepository.findAll();
		System.out.print(JSONObject.toJSON(accounts).toString());
		return JSONObject.toJSON(accounts).toString();
	}

	@Autowired
	private void test(){
		findAll();
	}
}
