package com.meva.finance.dto;





import com.meva.finance.modelo.Family;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@Data
public class FamilyDto {

    private Long idFamily;

    private String description;



    public Family converter() {
        return  Family.builder().idFamily(idFamily > 0 ? idFamily : null).description(description).build();
    }

}
