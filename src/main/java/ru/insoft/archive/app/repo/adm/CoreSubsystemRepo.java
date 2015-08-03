package ru.insoft.archive.app.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.app.domain.adm.CoreSubsystem;

public interface CoreSubsystemRepo extends JpaRepository<CoreSubsystem, Long> {
}
