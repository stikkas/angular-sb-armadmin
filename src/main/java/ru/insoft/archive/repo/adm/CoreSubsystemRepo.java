package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.CoreSubsystem;

public interface CoreSubsystemRepo extends JpaRepository<CoreSubsystem, Long> {
}
