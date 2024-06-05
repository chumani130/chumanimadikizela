package com.enviro.assessment.grad001.chumanimadikizela.controller;

import com.enviro.assessment.grad001.chumanimadikizela.dto.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.chumanimadikizela.service.DisposalGuideLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guideline")
public class DisposalGuideLineController {
    @Autowired
    private DisposalGuideLineService disposalGuideLineService;

    // retrieves a list of all waste categories  or READ
    @GetMapping
    public List<DisposalGuideLineDTO> getAllGuideLines() {
        return disposalGuideLineService.getAllGuideLines();
    }

    // read by id
    @GetMapping("/{id}")
    public DisposalGuideLineDTO getGuidelineByID(@PathVariable Long id) {
        return disposalGuideLineService.getGuideLineById(id);
    }

    // create
    @PostMapping("/")
    public DisposalGuideLineDTO createGuideLine(@RequestBody DisposalGuideLineDTO disposalGuideLineDTO) {
        return disposalGuideLineService.createGuideLine(new DisposalGuideLineDTO());
    }

    // update
    @PutMapping("/{id}")
    public DisposalGuideLineDTO updateGuideLine(@PathVariable Long id,
                                                @RequestBody DisposalGuideLineDTO disposalGuideLineDTO) {
        return disposalGuideLineService.updateGuideLine(id, disposalGuideLineDTO);
    }

    // delete
    public void deleteGuideLineById(@PathVariable Long id) {
        disposalGuideLineService.deleteGuideLine(id);
    }
}
