package web.manage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import web.manage.entities.Account;

/**
 *
 */
@Component
public interface AccountRepository extends CrudRepository<Account, Long> {
	/**
	 * 参照spring data jpa 可以根据方法名称查询出数据无需实现
	 * @param userName
	 * @return
	 */
	Account findByUserName(String userName);
	
	Account findByUserNameAndPassword(String userName, String password);
}
