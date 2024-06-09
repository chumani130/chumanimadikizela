package com.enviro.assessment.grad001.chumanimadikizela.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecyclingTipDTO {

    private Long id;
    @NotBlank(message = "Tip is mandatory")
    private String tip;
}
