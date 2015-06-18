package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.AdmAccessRule;

public interface AdmAccessRuleRepo extends JpaRepository<AdmAccessRule, Long> {
}
