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
        return recyclingTips.stream().map(this::transformTipsToDTO).collect(Collectors.toList());
    }

    @Override
    public RecyclingTipDTO getRecyclingTiById(Long id) {
        Optional<RecyclingTip> recyclingTip = recyclingTipRepository.findById(id);
        return recyclingTip.map(this::transformTipsToDTO).orElse(null);
    }

    @Override
    public RecyclingTipDTO createRecyclingTip(RecyclingTipDTO recyclingTipDTO) {
        RecyclingTip recyclingTip = RecyclingTip.builder()
                .tip(recyclingTipDTO.getTip())
                .build();
        RecyclingTip savedTip = recyclingTipRepository.save(recyclingTip);
        return transformTipsToDTO(savedTip);
    }

    @Override
    public RecyclingTipDTO updateRecyclingTip(Long id, RecyclingTipDTO recyclingTipDTO) {
        Optional<RecyclingTip> optionalRecyclingTip = recyclingTipRepository.findById(id);
        if (optionalRecyclingTip.isPresent()) {
            RecyclingTip recyclingTip = optionalRecyclingTip.get();
            recyclingTip.setTip(recyclingTipDTO.getTip());
            RecyclingTip savedTip = recyclingTipRepository.save(recyclingTip);
            return transformTipsToDTO(savedTip);
        } else {
            return null;
        }
    }
    @Override
    public void DeleteRecyclingTipById(Long id) {
        recyclingTipRepository.deleteById(id);
    }
    /**
     * this is our custom mapper, that maps our entity to our dtos
     *transformTipsToDTO converting entity into dto
     * @param recyclingTip
     * @return RecyclingTipDTO
     */
    private RecyclingTipDTO transformTipsToDTO(RecyclingTip recyclingTip) {
        return RecyclingTipDTO
                .builder()
                .id(recyclingTip.getId())
                .tip(recyclingTip.getTip())
                .build();
    }
}
