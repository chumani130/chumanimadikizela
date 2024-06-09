package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
import com.enviro.assessment.grad001.chumanimadikizela.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService{

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;
    @Override
    public List<WasteCategoryDTO> getAllCategories() {
        List<WasteCategory> wasteCategories = wasteCategoryRepository.findAll();
        return wasteCategories.stream().map(this::transformWasteCategoryToDTO).collect(Collectors.toList());
    }
    @Override
    public WasteCategoryDTO getCategoryById(Long id) {
        Optional<WasteCategory> wasteCategory = wasteCategoryRepository.findById(id);
        return wasteCategory.map(this::transformWasteCategoryToDTO).orElse(null);
    }
    @Override
    public WasteCategoryDTO createCategory(WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory wasteCategory = WasteCategory.builder()
                .name(wasteCategoryDTO.getName())
                .build();
        WasteCategory savedCategory = wasteCategoryRepository.save(wasteCategory);
        return transformWasteCategoryToDTO(savedCategory);
    }
    @Override
    public WasteCategoryDTO updateCategory(Long id, WasteCategoryDTO wasteCategoryDTO) {
        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findById(id);
        if (optionalWasteCategory.isPresent()) {
            WasteCategory wasteCategory = optionalWasteCategory.get();
            wasteCategory.setName(wasteCategoryDTO.getName());
            WasteCategory savedCategory = wasteCategoryRepository.save(wasteCategory);
            return transformWasteCategoryToDTO(savedCategory);
        } else {
            return null;
        }
    }
    @Override
    public void deleteCategoryById(Long id) {
        wasteCategoryRepository.deleteById(id);
    }

    /**
     * this is our custom mapper, that maps our entity to our dtos
     *transformWasteCategoryToDTO converting entity into dto
      * @param wasteCategory
     * @return WasteCategoryDTO
     */
    private WasteCategoryDTO transformWasteCategoryToDTO(WasteCategory wasteCategory) {
        return WasteCategoryDTO
                .builder()
                .id(wasteCategory.getId())
                .name(wasteCategory.getName())
                .build();
    }
}
