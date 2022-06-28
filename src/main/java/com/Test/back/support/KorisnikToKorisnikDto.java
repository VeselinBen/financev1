package com.Test.back.support;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.Test.back.model.User;
import com.Test.back.web.dto.KorisnikDTO;


@Component
public class KorisnikToKorisnikDto implements Converter<User, KorisnikDTO>{



    @Override
    public KorisnikDTO convert(User user) {
        KorisnikDTO korisnikDTO = new KorisnikDTO();

        korisnikDTO.setId(user.getId());
        korisnikDTO.seteMail(user.getEMail());
        korisnikDTO.setIme(user.getIme());
        korisnikDTO.setPrezime(user.getPrezime());
        korisnikDTO.setKorisnickoIme(user.getKorisnickoIme());

        return korisnikDTO;
    }

    public List<KorisnikDTO> convert(List<User> korisnici){
        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

        for(User k : korisnici) {
            KorisnikDTO dto = convert(k);
            korisnikDTOS.add(dto);
        }

        return korisnikDTOS;
    }
}
