package ru.insoft.archive.app.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.app.domain.adm.DescriptorValueAttr;

public interface DescriptorValueAttrRepo extends JpaRepository<DescriptorValueAttr, Long> {
}
