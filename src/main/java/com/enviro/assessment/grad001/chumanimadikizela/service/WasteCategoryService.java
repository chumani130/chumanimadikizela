package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
import com.enviro.assessment.grad001.chumanimadikizela.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface WasteCategoryService {
        public List<WasteCategoryDTO> getAllCategories();
        public WasteCategoryDTO getCategoryById(Long id);

        public WasteCategoryDTO createCategory(WasteCategoryDTO wasteCategoryDTO);

        public WasteCategoryDTO update(Long id, WasteCategoryDTO wasteCategoryDTO);


        void deleteCategoryById(Long id);

}
