package ru.insoft.archive.app.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.app.domain.adm.AdmGroup;

public interface AdmGroupRepo extends JpaRepository<AdmGroup, Long> {
}
