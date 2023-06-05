package com.meva.finance.repository;

import com.meva.finance.modelo.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    @Query(value = "SELECT id_family FROM family where id_family = :idFamily", nativeQuery = true)
    Long retornaUmaFamily(Long idFamily);
}

