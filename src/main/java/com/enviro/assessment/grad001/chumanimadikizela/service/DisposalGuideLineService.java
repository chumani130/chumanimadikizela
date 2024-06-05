package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.DisposalGuideLineDTO;

import java.util.List;

public interface DisposalGuideLineService {
    public List<DisposalGuideLineDTO> getAllGuideLines();

    public DisposalGuideLineDTO getGuideLineById(Long id);

    public DisposalGuideLineDTO createGuideLine(DisposalGuideLineDTO disposalGuideLineDTO);

    public DisposalGuideLineDTO updateGuideLine(Long id, DisposalGuideLineDTO disposalGuideLineDTO);

    void deleteGuideLine(Long id);


}
