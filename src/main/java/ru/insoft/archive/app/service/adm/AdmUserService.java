package ru.insoft.archive.app.service.adm;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.insoft.archive.app.domain.adm.AdmUser;
import ru.insoft.archive.app.repo.adm.AdmUserRepo;

@Service
public class AdmUserService {

	@Autowired
	private AdmUserRepo repo;

	public Optional<AdmUser> find(String login) {
		return repo.findOneByLoginIgnoreCase(login);
	}
}
