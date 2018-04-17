//package web.manage.configs.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import web.manage.entities.Account;
//import web.manage.repositories.AccountRepository;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	// 查询用户使用
//	@Autowired
//	AccountRepository accountRepository;
//
//	@Autowired
//	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		// auth.inMemoryAuthentication()
//		// .withUser("user").password("password").roles("USER")
//		// .and()
//		// .withUser("app_client").password("nopass").roles("USER")
//		// .and()
//		// .withUser("admin").password("password").roles("ADMIN");
//		//配置用户来源于数据库
//		auth.userDetailsService(userDetailsService());
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and()
//				.formLogin().loginPage("/login").permitAll().and()
//				.httpBasic().and().csrf().disable();
//		http.authorizeRequests();
//
////				.antMatchers(StaticParams.PATHREGX.NOAUTH,
////						StaticParams.PATHREGX.CSS,StaticParams.PATHREGX.JS,StaticParams.PATHREGX.IMG).permitAll()//无需访问权限
////
////				.antMatchers(StaticParams.PATHREGX.AUTHADMIN).hasAuthority(StaticParams.USERROLE.ROLE_ADMIN)//admin角色访问权限
////
////				.antMatchers(StaticParams.PATHREGX.AUTHUSER).hasAuthority(StaticParams.USERROLE.ROLE_USER)//user角色访问权限
//
////				.anyRequest()//all others request authentication
////				.authenticated()
////				.and()
////				.formLogin().loginPage("/login").permitAll()
////				.and()
////				.logout().permitAll();
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//				// 通过用户名获取用户信息
//				Account account = accountRepository.findByUserName(name);
//				if (account != null) {
//					// 创建spring security安全用户
//					User user = new User(account.getUserName(), account.getPassword(),
//							AuthorityUtils.createAuthorityList(account.getRoles()));
//					return user;
//				} else {
//					throw new UsernameNotFoundException("用户[" + name + "]不存在");
//				}
//			}
//		};
//	}
//
//}
