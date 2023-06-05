package com.meva.finance.service;


import com.meva.finance.dto.FamilyDto;
import com.meva.finance.dto.UsersDto;
import com.meva.finance.modelo.Family;
import com.meva.finance.modelo.Users;
import com.meva.finance.repository.FamilyRepository;
import com.meva.finance.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Objects;

@Slf4j
@Service
public class UserService {


    private UsersRepository usuariosRepository;

    private FamilyRepository familyRepository;

    @Autowired
    public UserService(FamilyRepository familyRepository, UsersRepository usersRepository){
        this.familyRepository = familyRepository;
        this.usuariosRepository = usersRepository;
    }


    public String serviceCadastrar(@NotNull UsersDto dto) throws ValidationException {
        Users usuarios = dto.converter(dto);
        usuarios.setFamily(validationFamily(dto.getFamilyDto()));

        return usuariosRepository.save(usuarios).getCpf();

    }

    public Family validationFamily(FamilyDto familyDto) throws ValidationException{

        if (familyDto.getIdFamily()  ==0){
            Family  family = familyDto.converter();
            return familyRepository.save(family);
            
        } else if (!Objects.nonNull(familyRepository.retornaUmaFamily(familyDto.getIdFamily()))) {

            log.error("ID da Familia não encontrado");
            throw new ValidationException("ID da Familia não encontrado");

        }
        return familyDto.converter();
    }


    public Users atualizar(UsersDto usersDto) {
        Users usuarios = usersDto.converter(usersDto);

        return usuariosRepository.save(usuarios);
    }

    public void remover(String id){
        usuariosRepository.deleteById(id);
    }


}
