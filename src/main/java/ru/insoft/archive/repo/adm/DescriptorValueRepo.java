package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.DescriptorValue;

public interface DescriptorValueRepo extends JpaRepository<DescriptorValue, Long> {
}
