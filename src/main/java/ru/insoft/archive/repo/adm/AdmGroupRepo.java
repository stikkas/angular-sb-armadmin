package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.AdmGroup;

public interface AdmGroupRepo extends JpaRepository<AdmGroup, Long> {
}