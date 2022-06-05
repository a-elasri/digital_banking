package com.elasri.digital_bank_backend.repositories;

import com.elasri.digital_bank_backend.entities.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, String> {
}
