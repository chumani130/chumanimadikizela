package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.RecyclingTipDTO;

import java.util.List;

public interface RecyclingTipService {

    public List<RecyclingTipDTO> getAllRecyclingTips();

    public RecyclingTipDTO getRecyclingTiById(Long id);

    public RecyclingTipDTO createRecyclingTip(RecyclingTipDTO recyclingTipDTO);

    public RecyclingTipDTO updateRecyclingTip(Long id, RecyclingTipDTO recyclingTipDTO);

    void DeleteRecyclingTipById(Long id);
}
