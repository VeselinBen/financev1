package com.Test.back.support;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.Test.back.model.User;
import com.Test.back.service.UserService;
import com.Test.back.web.dto.KorisnikDTO;


@Component
@RequiredArgsConstructor
public class KorisnikDtoToKorisnik implements Converter<KorisnikDTO, User> {

    private UserService korisnikService;

    @Override
    public User convert(KorisnikDTO korisnikDTO) {
        User user = null;
        if(korisnikDTO.getId() != null) {
            user = korisnikService.findOne(korisnikDTO.getId()).get();
        }

        if(user == null) {
            user = new User();
        }

        user.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        user.setEMail(korisnikDTO.geteMail());
        user.setIme(korisnikDTO.getIme());
        user.setPrezime(korisnikDTO.getPrezime());

        return user;
    }
}
