package com.enviro.assessment.grad001.chumanimadikizela.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisposalGuideLineDTO {

    private Long id;
    private String guideline;
}
