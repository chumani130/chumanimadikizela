package com.enviro.assessment.grad001.chumanimadikizela.controller;

import com.enviro.assessment.grad001.chumanimadikizela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.chumanimadikizela.service.RecyclingTipService;
import com.enviro.assessment.grad001.chumanimadikizela.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tip")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService recyclingTipService;

    // retrieves a list of all waste categories  or READ
    @GetMapping
    public List<RecyclingTipDTO> getAllTips() {
        return recyclingTipService.getAllRecyclingTips();
    }

    // read by id
    @GetMapping("/{id}")
    public RecyclingTipDTO getTipsById(@PathVariable Long id) {
        return recyclingTipService.getRecyclingTiById(id);
    }

    // create
    @PostMapping("/")
    public RecyclingTipDTO createRecyclingTip(@RequestBody RecyclingTipDTO recyclingTipDTO) {
        return recyclingTipService.createRecyclingTip(recyclingTipDTO);
    }

    // update
    @PutMapping("/{id}")
    public RecyclingTipDTO updateRecyclingTip(@PathVariable Long id,
                                              @RequestBody RecyclingTipDTO recyclingTipDTO) {
        return recyclingTipService.updateRecyclingTip(id, recyclingTipDTO);
    }

    // delete
    @DeleteMapping
    public void deleteRecycleTipById(@PathVariable Long id) {
        recyclingTipService.getRecyclingTiById(id);
    }
}
