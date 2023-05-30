package com.meva.finance.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "user_meva")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    private String cpf;
    @Column(name = "name")
    private String nome;
    @Column(name = "genre")
    private String genero;
    @Column(name = "date")
    private LocalDate dataNascimento;
    @Column(name = "state")
    private String estado;
    @Column(name = "city")
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "id_family")
    private Family family;


}
