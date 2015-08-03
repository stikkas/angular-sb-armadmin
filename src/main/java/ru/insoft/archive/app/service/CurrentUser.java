package ru.insoft.archive.app.service;

import java.util.Collection;
import static java.util.stream.Collectors.toSet;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import ru.insoft.archive.app.domain.adm.AdmAccessRule;
import ru.insoft.archive.app.domain.adm.AdmUser;

/**
 * Представляет описание авторизовавшегося пользователя
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public class CurrentUser implements UserDetails {

	private final AdmUser user;

	public CurrentUser(AdmUser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(user.getGroups().stream().flatMap(g -> g.getRules().stream())
				.map(AdmAccessRule::getCode).collect(toSet()).toArray(new String[0]));
	}

	@Override
	public String getPassword() {
		return user.getPassword().toLowerCase();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !user.isBlocked();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isBlocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isBlocked();
	}

	@Override
	public boolean isEnabled() {
		return !user.isBlocked();
	}

}
