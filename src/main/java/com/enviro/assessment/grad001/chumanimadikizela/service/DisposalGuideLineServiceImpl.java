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
        return disposalGuideLines.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public DisposalGuideLineDTO getGuideLineById(Long id) {
        Optional<DisposalGuideLine> disposalGuideLine = disposalGuideLineRepository.findById(id);
        return disposalGuideLine.map(this::convertToDTO).orElse(null);
    }

    @Override
    public DisposalGuideLineDTO createGuideLine(DisposalGuideLineDTO disposalGuideLineDTO) {
        DisposalGuideLine disposalGuideLine = new DisposalGuideLine();
        disposalGuideLine.setGuideline(disposalGuideLine.getGuideline());
        DisposalGuideLine savedGuideLine = disposalGuideLineRepository.save(disposalGuideLine);
        return convertToDTO(savedGuideLine);
    }

    @Override
    public DisposalGuideLineDTO updateGuideLine(Long id, DisposalGuideLineDTO disposalGuideLineDTO) {
        Optional<DisposalGuideLine> optionalDisposalGuideLine = disposalGuideLineRepository.findById(id);
        if (optionalDisposalGuideLine.isPresent()) {
            DisposalGuideLine disposalGuideLine = optionalDisposalGuideLine.get();
            disposalGuideLine.setGuideline(disposalGuideLineDTO.getGuideline());
            DisposalGuideLine savedGuideLine = disposalGuideLineRepository.save(disposalGuideLine);
            return convertToDTO(disposalGuideLine);
        } else {
            return null;
        }
    }

    @Override
    public void deleteGuideLine(Long id) {
        disposalGuideLineRepository.deleteById(id);
    }

    private DisposalGuideLineDTO convertToDTO(DisposalGuideLine disposalGuideLine) {
        DisposalGuideLineDTO dto = new DisposalGuideLineDTO();
        dto.setId(disposalGuideLine.getId());
        dto.setGuideline(disposalGuideLine.getGuideline());
        return dto;
    }
}
