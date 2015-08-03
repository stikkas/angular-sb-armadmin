package ru.insoft.archive.app.service.adm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.insoft.archive.app.domain.adm.AdmUser;
import ru.insoft.archive.app.service.CurrentUser;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AdmUserService service;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		AdmUser user = service.find(login).orElseThrow(()
				-> new UsernameNotFoundException(
						String.format("Пользователь с именем '%s' не существует", login)));
		return new CurrentUser(user);
	}

}
