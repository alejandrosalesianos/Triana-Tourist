package com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest;

import com.salesianostriana.dam.TrianaTourist.validation.multiple.NoDuplicatePhoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
@NoDuplicatePhoto(photos = {"coverPhoto", "photo2", "photo3"})
public class CreatePointOfInterestDto {

    @NotBlank
    private String name;
    @Pattern(regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$")
    private String location;
    private String description;
    private LocalDateTime date;
    private Long category;
    @NotBlank
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))")
    private String coverPhoto;
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))")
    private String photo2;
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))")
    private String photo3;
}
