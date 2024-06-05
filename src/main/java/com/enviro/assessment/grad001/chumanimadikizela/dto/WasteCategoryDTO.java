package com.enviro.assessment.grad001.chumanimadikizela.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WasteCategoryDTO {
    private Long id;
    private String name;
}
