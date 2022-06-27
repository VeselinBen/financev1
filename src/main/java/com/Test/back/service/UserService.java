package com.Test.back.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.Test.back.model.User;
import com.Test.back.web.dto.KorisnikPromenaLozinkeDto;


public interface UserService {

    Optional<User> findOne(Long id);

    List<User> findAll();

    Page<User> findAll(int brojStranice);

    User save(User user);

    void delete(Long id);

    Optional<User> findbyKorisnickoIme(String korisnickoIme);

    boolean changePassword(Long id, KorisnikPromenaLozinkeDto korisnikPromenaLozinkeDto);
}
