package com.enviro.assessment.grad001.chumanimadikizela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="Waste Category")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Category name is mandatory")
    private String name;
}
