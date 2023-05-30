package com.meva.finance.modelo;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "family")
@NoArgsConstructor
@ToString
@Data
@Builder
@AllArgsConstructor
public class Family {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_family_seq")
    @SequenceGenerator(name = "id_family_seq", sequenceName = "id_family_seq", allocationSize = 1)
    @Column(name = "id_family")
    private Long idFamily;

    private String description;


}
