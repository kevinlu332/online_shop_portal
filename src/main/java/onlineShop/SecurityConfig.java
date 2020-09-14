package onlineShop;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.context.annotation.Bean;


//for authorization & authentication
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	private DataSource dataSource;
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//set a back-door for a super user
		auth
			.inMemoryAuthentication().withUser("admin@gmail.com")
					.password("123123").authorities("ROLE_ADMIN");
		
		//Ҳ���ԣ� ���ĸ����ݿ���
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("SELECT emailId, password, enabled FROM users WHERE emailId=?")
			.authoritiesByUsernameQuery("SELECT emailId, authorities FROM authorities WHERE emailId=?");
		//�ҵ��û����� ���������ͬ�񣬺󣬿�����authority
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		//csrf() �Ǹ�©�����ڲ��������֤������£�Ӧ��disable
		http
			.csrf().disable()
			.formLogin()
				.loginPage("/login")
			.and()
			.authorizeRequests()
			//to goto /cart, check user has authority of ("ROLE_user")
			.antMatchers("/cart/**").hasAuthority("ROLE_USER")
			//to goto /get, check user has authority of ("ROLE_user") or ("ROLE_ADMIN")
			.antMatchers("/get*/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
			.antMatchers("/admin*/**").hasAuthority("ROLE_ADMIN")
			.anyRequest().permitAll()
			.and()
			.logout()
				.logoutUrl("/logout");
	}

       @SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	

	
	
	
	
	
}
