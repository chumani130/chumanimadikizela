package com.enviro.assessment.grad001.chumanimadikizela.controller;

import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
import com.enviro.assessment.grad001.chumanimadikizela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.chumanimadikizela.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService wasteCategoryService;

    // retrieves a list of all waste categories  or READ
    @GetMapping
    public List<WasteCategoryDTO> getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    // read by id
    @GetMapping("/{id}")
    public WasteCategoryDTO getCategoryById(@PathVariable Long id) {
        return wasteCategoryService.getCategoryById(id);
    }

    // create
    @PostMapping("/")
    public WasteCategoryDTO createCategory(@RequestBody WasteCategoryDTO wasteCategoryDTO) {
        return wasteCategoryService.createCategory(wasteCategoryDTO);
    }

    // update
    @PutMapping("/{id}")
    public WasteCategoryDTO updateCategory(@PathVariable Long id, @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        return wasteCategoryService.updateCategory(id, wasteCategoryDTO);
    }

    // delete
    public void deleteCategoryById(@PathVariable Long id) {
        wasteCategoryService.deleteCategoryById(id);
    }
}
