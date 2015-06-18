package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.AdmUser;

public interface AdmUserRepo extends JpaRepository<AdmUser, Long> {
}
