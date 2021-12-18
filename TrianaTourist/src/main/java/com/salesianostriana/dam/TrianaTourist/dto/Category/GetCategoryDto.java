package com.salesianostriana.dam.TrianaTourist.dto.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetCategoryDto {

    private Long id;
    private String name;
}
