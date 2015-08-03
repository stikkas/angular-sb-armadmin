package ru.insoft.archive.app.repo.adm;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.app.domain.adm.AdmUser;

public interface AdmUserRepo extends JpaRepository<AdmUser, Long> {

	Optional<AdmUser> findOneByLoginIgnoreCase(String login);
}
