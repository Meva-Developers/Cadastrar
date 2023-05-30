package com.meva.finance.service;

import com.meva.finance.dto.UsersDto;
import com.meva.finance.modelo.Users;
import com.meva.finance.repository.FamilyRepository;
import com.meva.finance.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService {

    @Autowired
    private UsersRepository usuariosRepository;
    @Autowired
    private FamilyRepository familyRepository;


    public String serviceCadastrar(UsersDto dto){
        Users usuarios = dto.converter(dto);

        return usuariosRepository.save(usuarios).getCpf();
     
    }

    public Users atualizar(UsersDto usersDto) {
        Users usuarios = usersDto.converter(usersDto);

        return usuariosRepository.save(usuarios);
    }



}
