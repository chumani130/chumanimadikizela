package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
import com.enviro.assessment.grad001.chumanimadikizela.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WasteCategoryServiceImpl implements WasteCategoryService{

        @Autowired
    private WasteCategoryRepository wasteCategoryRepository;
    @Override
    public List<WasteCategoryDTO> getAllCategories() {
        return null;
    }

    @Override
    public WasteCategoryDTO getCategoryById(Long id) {
        return null;
    }

    @Override
    public WasteCategoryDTO createCategory(WasteCategoryDTO wasteCategoryDTO) {
        return null;
    }

    @Override
    public WasteCategoryDTO update(Long id, WasteCategoryDTO wasteCategoryDTO) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}

//@Service
//public class WasteCategoryService {

//
//    public List<WasteCategoryDTO> getAllCategories() {
//        return wasteCategoryRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
//    }
//
//    public WasteCategoryDTO getCategoryById(Long id) {
//        Optional<WasteCategory> wasteCategory = wasteCategoryRepository.findById(id);
//        return wasteCategory.map(this.convertToDTO).orElse(null);
//    }
//
//    public WasteCategoryDTO createCategory(WasteCategoryDTO wasteCategoryDTO) {
//        WasteCategory wasteCategory = new WasteCategory();
//        wasteCategory.setName(wasteCategoryDTO.getName());
//        WasteCategory savedCategory = wasteCategoryRepository.save(wasteCategory);
//        return convertToDTO(savedCategory);
//    }
//
//    public WasteCategoryDTO update(Long id, WasteCategoryDTO wasteCategoryDTO) {
//        Optional<WasteCategory> wasteCategory = wasteCategoryRepository.findById(id);
//        if ( wasteCategory.isPresent()) {
//            WasteCategory updatedCategory = wasteCategory.get();
//            updatedCategory.setName(wasteCategoryDTO.getName());
//            wasteCategoryRepository.save(updatedCategory);
//            return convertToDTO(updatedCategory);
//        } else {
//            return null;
//        }
//    }
//
//    public boolean deleteCategory(Long id) {
//        if (wasteCategoryRepository.existsById(id)) {
//            wasteCategoryRepository.deleteById(id);
//            return true;
//        } else {
//            return false;
//        }
//
//        private WasteCategoryDTO convertToDTO(WasteCategory wasteCategory) {
//            WasteCategoryDTO dto = new WasteCategoryDTO();
//            dto.setId(wasteCategory.getId());
//            dto.setName(wasteCategory,getName());
//            return dto;
//        }
//    }
//}
