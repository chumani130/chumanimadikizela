package com.enviro.assessment.grad001.chumanimadikizela.repository;

import com.enviro.assessment.grad001.chumanimadikizela.model.DisposalGuideLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuideLineRepository extends JpaRepository<DisposalGuideLine, Long> {
}
