package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.chumanimadikizela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.DisposalGuideLine;
import com.enviro.assessment.grad001.chumanimadikizela.model.RecyclingTip;
import com.enviro.assessment.grad001.chumanimadikizela.repository.DisposalGuideLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisposalGuideLineServiceImpl implements DisposalGuideLineService {

    private DisposalGuideLineRepository disposalGuideLineRepository;
    @Override
    public List<DisposalGuideLineDTO> getAllGuideLines() {
        List<DisposalGuideLine> disposalGuideLines = disposalGuideLineRepository.findAll();
        return disposalGuideLines.stream().map(this::transformGuideLineToDTO).collect(Collectors.toList());
    }

    @Override
    public DisposalGuideLineDTO getGuideLineById(Long id) {
        Optional<DisposalGuideLine> disposalGuideLine = disposalGuideLineRepository.findById(id);
        return disposalGuideLine.map(this::transformGuideLineToDTO).orElse(null);
    }

    @Override
    public DisposalGuideLineDTO createGuideLine(DisposalGuideLineDTO disposalGuideLineDTO) {
        // using build to transform the dto into an entity so that we can create a record
        // with-in disposal guide table
        DisposalGuideLine disposalGuideLine = DisposalGuideLine.builder()
                .guideline(disposalGuideLineDTO.getGuideline())
                .build();
        DisposalGuideLine savedGuideLine = disposalGuideLineRepository.save(disposalGuideLine);
        return transformGuideLineToDTO(savedGuideLine);
    }

    @Override
    public DisposalGuideLineDTO updateGuideLine(Long id, DisposalGuideLineDTO disposalGuideLineDTO) {
        Optional<DisposalGuideLine> optionalDisposalGuideLine = disposalGuideLineRepository.findById(id);
        if (optionalDisposalGuideLine.isPresent()) {
            DisposalGuideLine disposalGuideLine = optionalDisposalGuideLine.get();
            disposalGuideLine.setGuideline(disposalGuideLineDTO.getGuideline());
            DisposalGuideLine savedGuideLine = disposalGuideLineRepository.save(disposalGuideLine);
            return transformGuideLineToDTO(disposalGuideLine);
        } else {
            return null;
        }
    }

    @Override
    public void deleteGuideLine(Long id) {
        disposalGuideLineRepository.deleteById(id);
    }
    /**
     * this is our custom mapper, that maps our entity to our dtos
     *transformGuideLineToDTO converting entity into dto
     * @param disposalGuideLine
     * @return DisposalGuideLineDTO
     */
    private DisposalGuideLineDTO transformGuideLineToDTO(DisposalGuideLine disposalGuideLine) {
        return DisposalGuideLineDTO
                .builder()
                .id(disposalGuideLine.getId())
                .guideline(disposalGuideLine.getGuideline())
                .build();
    }
}
