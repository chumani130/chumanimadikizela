package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.RecyclingTip;
import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
import com.enviro.assessment.grad001.chumanimadikizela.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {
    @Autowired
    private RecyclingTipRepository recyclingTipRepository;
    @Override
    public List<RecyclingTipDTO> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipRepository.findAll();
        return recyclingTips.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RecyclingTipDTO getRecyclingTiById(Long id) {
        Optional<RecyclingTip> recyclingTip = recyclingTipRepository.findById(id);
        return recyclingTip.map(this::convertToDTO).orElse(null);
    }

    @Override
    public RecyclingTipDTO createRecyclingTip(RecyclingTipDTO recyclingTipDTO) {
        RecyclingTip recyclingTip = new RecyclingTip();
        recyclingTip.setTip(recyclingTip.getTip());
        RecyclingTip savedTip = recyclingTipRepository.save(recyclingTip);
        return convertToDTO(savedTip);
    }

    @Override
    public RecyclingTipDTO updateRecyclingTip(Long id, RecyclingTipDTO recyclingTipDTO) {
        Optional<RecyclingTip> optionalRecyclingTip = recyclingTipRepository.findById(id);
        if (optionalRecyclingTip.isPresent()) {
            RecyclingTip recyclingTip = optionalRecyclingTip.get();
            recyclingTip.setTip(recyclingTipDTO.getTip());
            RecyclingTip savedTip = recyclingTipRepository.save(recyclingTip);
            return convertToDTO(savedTip);
        } else {
            return null;
        }
    }
    @Override
    public void DeleteRecyclingTipById(Long id) {
        recyclingTipRepository.deleteById(id);
    }
    private RecyclingTipDTO convertToDTO(RecyclingTip recyclingTip) {
        RecyclingTipDTO dto = new RecyclingTipDTO();
        dto.setId(recyclingTip.getId());
        dto.setTip(recyclingTip.getTip());
        return dto;
    }
}
