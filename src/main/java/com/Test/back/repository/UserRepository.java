package com.Test.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Test.back.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByKorisnickoIme(String korisnickoIme);

    Optional<User> findFirstByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
