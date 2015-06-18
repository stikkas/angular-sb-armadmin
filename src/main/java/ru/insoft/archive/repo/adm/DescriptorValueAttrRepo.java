package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.DescriptorValueAttr;

public interface DescriptorValueAttrRepo extends JpaRepository<DescriptorValueAttr, Long> {
}
