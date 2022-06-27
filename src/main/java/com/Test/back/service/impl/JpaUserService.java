package com.Test.back.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Test.back.enumeration.KorisnickaUloga;
import com.Test.back.model.User;
import com.Test.back.repository.UserRepository;
import com.Test.back.service.UserService;
import com.Test.back.web.dto.KorisnikPromenaLozinkeDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JpaUserService implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(int brojStranice) {
        return userRepository.findAll(PageRequest.of(brojStranice,10));
    }

    @Override
    public User save(User user) {
        user.setUloga(KorisnickaUloga.KORISNIK);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findbyKorisnickoIme(String korisnickoIme) {
        return userRepository.findFirstByKorisnickoIme(korisnickoIme);
    }

    @Override
    public boolean changePassword(Long id, KorisnikPromenaLozinkeDto korisnikPromenaLozinkeDto) {
        Optional<User> rezultat = userRepository.findById(id);

        if(!rezultat.isPresent()) {
            throw new EntityNotFoundException();
        }

        User user = rezultat.get();

        if(!user.getKorisnickoIme().equals(korisnikPromenaLozinkeDto.getKorisnickoIme())
                || !user.getLozinka().equals(korisnikPromenaLozinkeDto.getLozinka())){
            return false;
        }

        String password = korisnikPromenaLozinkeDto.getLozinka();
        if (!korisnikPromenaLozinkeDto.getLozinka().equals("")) {
            password = passwordEncoder.encode(korisnikPromenaLozinkeDto.getLozinka());
        }

        user.setLozinka(password);

        userRepository.save(user);

        return true;
    }
}
