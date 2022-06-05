package com.elasri.digital_bank_backend.security.service;


import com.elasri.digital_bank_backend.security.entities.AppRole;
import com.elasri.digital_bank_backend.security.entities.AppUser;

import java.util.List;

public interface SecurityService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser( String username, String roleName);
    AppUser loadUserByUsername( String username);
    List<AppUser> listUsers();
}
