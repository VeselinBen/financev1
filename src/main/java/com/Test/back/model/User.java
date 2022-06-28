package com.Test.back.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.Test.back.enumeration.KorisnickaUloga;

import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column(unique = true, nullable = false)
    private String eMail;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column(nullable = false)
    @Size(min = 8)
    private String lozinka;

    @Enumerated(EnumType.STRING)
    private KorisnickaUloga uloga;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

}
