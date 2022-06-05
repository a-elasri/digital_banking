package com.elasri.digital_bank_backend.security.repositories;

import com.elasri.digital_bank_backend.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRoleName( String roleName);
}
