package com.Test.back.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Test.back.model.User;
import com.Test.back.service.UserService;


@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserService korisnikService;

  /* Zelimo da predstavimo korisnika preko UserDetails klase - nacina
  *  na koji Spring boot predstavlja korisnika. Ucitamo na osnovu korisnickog imena
  *  korisnika iz nase mysql baze i u okviru UserDetails namapiramo njegove podatke
  *  - kredencijale i rolu kroz GrantedAuthorities. */
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = korisnikService.findbyKorisnickoIme(username).orElse(null);

    if (user == null) {
      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
    } else {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        // korisnik moze imati vise od jedne uloge te za svaku ulogu mogu biti definisana prava
        String role = "ROLE_" + user.getUloga().toString();
        //String role = korisnik.getUloga().toString();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));

        return new org.springframework.security.core.userdetails.User(
                user.getKorisnickoIme().trim(),
                user.getLozinka().trim(),
                grantedAuthorities);
    }
  }
}
