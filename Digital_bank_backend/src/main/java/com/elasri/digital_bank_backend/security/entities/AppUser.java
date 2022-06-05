package com.elasri.digital_bank_backend.security.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    private String id;
    private String username;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany( fetch = FetchType.EAGER )
    private Collection<AppRole> roles = new ArrayList<>();

}

