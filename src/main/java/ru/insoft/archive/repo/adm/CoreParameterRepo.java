package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.CoreParameter;

public interface CoreParameterRepo extends JpaRepository<CoreParameter, String> {
}
