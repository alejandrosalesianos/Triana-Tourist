package com.salesianostriana.dam.TrianaTourist.dto.Category;

import com.salesianostriana.dam.TrianaTourist.validation.simple.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateCategoryDto {

    @NotBlank
    @UniqueName
    private String name;
}
