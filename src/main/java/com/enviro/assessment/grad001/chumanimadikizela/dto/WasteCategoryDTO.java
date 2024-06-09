package com.enviro.assessment.grad001.chumanimadikizela.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategoryDTO {
    private Long id;
    @NotBlank(message = "Category name is mandatory")
    private String name;
}
