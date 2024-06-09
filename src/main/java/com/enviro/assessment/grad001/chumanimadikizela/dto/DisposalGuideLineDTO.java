package com.enviro.assessment.grad001.chumanimadikizela.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisposalGuideLineDTO {

    private Long id;
    @NotBlank(message = "Guideline is mandatory")
    private String guideline;
}
