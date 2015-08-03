package ru.insoft.archive.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.insoft.archive.app.Application;
import ru.insoft.archive.app.service.adm.MyUserDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CurrentUserTests {

	@Autowired
	private MyUserDetailsService service;

	/**
	 * Проверяем авторизацию пользователя sic_s с паролем sic_s
	 */
	@Test
	public void userRulesTest() {
		UserDetails details = service.loadUserByUsername("sic_s");
		details.getAuthorities().forEach((a) -> {
			System.out.println(a);
		});
		Assert.assertEquals("Password not match", new Md5PasswordEncoder()
				.encodePassword("sic_s", null), details.getPassword());
	}
}
