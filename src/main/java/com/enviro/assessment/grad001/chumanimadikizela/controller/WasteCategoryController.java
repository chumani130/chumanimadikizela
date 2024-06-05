//package com.enviro.assessment.grad001.chumanimadikizela.controller;
//
//import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
//import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
//import com.enviro.assessment.grad001.chumanimadikizela.repository.WasteCategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/waste-categories")
//public class WasteCategoryController {
//    @Autowired
//    private WasteCategoryService wasteCategoryService;
//
//    // retrieving all waste categories
//    @GetMapping
//    public List<WasteCategory> getAllCategories() {
//        return wasteCategoryService.getAllCategories();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id) {
//        WasteCategoryDTO categoryDTO = wasteCategoryService.getCategoryById(id);
//        return categoryDTO != null ? ResponseEntity.ok(categoryDTO) : ResponseEntity.notFound;
//    }
//}
