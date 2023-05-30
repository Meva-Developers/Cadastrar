package com.meva.finance.dto;





import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class FamilyDto {

    private Long idFamily;

    private String description;


    public FamilyDto converter(FamilyDto familyDto) {
        return  FamilyDto.builder().idFamily(idFamily > 0 ? idFamily : null).description(description).build();
    }

}
