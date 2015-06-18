package ru.insoft.archive.repo.adm;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.insoft.archive.domain.adm.DescDatatype;

public interface DescDatatypeRepo extends JpaRepository<DescDatatype, String> {
}
