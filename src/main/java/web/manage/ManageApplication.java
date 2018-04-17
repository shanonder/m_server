package web.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import web.manage.entities.Account;
import web.manage.repositories.AccountRepository;

@SpringBootApplication
public class ManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageApplication.class, args);
	}

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	public void init(){
		try {
			if(accountRepository.findByUserName("admin") == null) {
				Account account=new Account();
				account.setUserName("admin");
				account.setPassword("admin");
				account.setPower("admin");
				accountRepository.save(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
