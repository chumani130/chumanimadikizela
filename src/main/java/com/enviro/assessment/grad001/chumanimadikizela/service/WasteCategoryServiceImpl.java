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
        return wasteCategories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    @Override
    public WasteCategoryDTO getCategoryById(Long id) {
        Optional<WasteCategory> wasteCategory = wasteCategoryRepository.findById(id);
        return wasteCategory.map(this::convertToDTO).orElse(null);
    }
    @Override
    public WasteCategoryDTO createCategory(WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory wasteCategory = new WasteCategory();
        wasteCategory.setName(wasteCategory.getName());
        WasteCategory savedCategory = wasteCategoryRepository.save(wasteCategory);
        return convertToDTO(savedCategory);
    }
    @Override
    public WasteCategoryDTO updateCategory(Long id, WasteCategoryDTO wasteCategoryDTO) {
        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findById(id);
        if (optionalWasteCategory.isPresent()) {
            WasteCategory wasteCategory = optionalWasteCategory.get();
            wasteCategory.setName(wasteCategoryDTO.getName());
            WasteCategory savedCategory = wasteCategoryRepository.save(wasteCategory);
            return convertToDTO(savedCategory);
        } else {
            return null;
        }
    }
    @Override
    public void deleteCategoryById(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
    private WasteCategoryDTO convertToDTO(WasteCategory wasteCategory) {
        WasteCategoryDTO dto = new WasteCategoryDTO();
        dto.setId(wasteCategory.getId());
        dto.setName(wasteCategory.getName());
        return dto;
    }
}
