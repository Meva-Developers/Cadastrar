package com.meva.finance.dto;


;
import com.meva.finance.modelo.Family;
import com.meva.finance.modelo.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UsersDto {


    private String name;
    private String cpf;

    private LocalDate date;

    private String city;

    private String state;

    private String genre;
    private FamilyDto familyDto;


    public UsersDto(Users users) {
        this.cpf = users.getCpf();
        this.name = users.getNome();
        this.city = users.getCidade();
        this.state = users.getEstado();
        this.genre = users.getGenero();

    }


    public Users converter(UsersDto dto) {
        return Users.builder().nome(name).cpf(cpf).dataNascimento(date).cidade(city).estado(state).genero(genre).build();
    }


}
