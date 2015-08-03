package ru.insoft.archive.app.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.app.domain.adm.AdmEmployee;

public interface AdmEmployeeRepo extends JpaRepository<AdmEmployee, Long> {
}
