package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.DescriptorGroup;

public interface DescriptorGroupRepo extends JpaRepository<DescriptorGroup, Long> {
}
