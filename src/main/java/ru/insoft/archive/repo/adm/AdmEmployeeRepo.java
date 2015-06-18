package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.AdmEmployee;

public interface AdmEmployeeRepo extends JpaRepository<AdmEmployee, Long> {
}
