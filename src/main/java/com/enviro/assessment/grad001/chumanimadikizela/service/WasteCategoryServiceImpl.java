//package com.enviro.assessment.grad001.chumanimadikizela.service;
//
//import com.enviro.assessment.grad001.chumanimadikizela.dto.WasteCategoryDTO;
//import com.enviro.assessment.grad001.chumanimadikizela.model.WasteCategory;
//import com.enviro.assessment.grad001.chumanimadikizela.repository.WasteCategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class WasteCategoryServiceImpl implements WasteCategoryService {
//
//    @Autowired
//    private WasteCategoryRepository wasteCategoryRepository;
//
//    // Save operation
//
//    // Read operation
//
//    // Update operation
//
//
//    // Delete operation
//
//
//    @Override
//    public List<WasteCategoryDTO> getAllCategories() {
//            List<WasteCategoryDTO> wasteCategoryDTOS = new ArrayList<>();
//            List<WasteCategory> wasteCategories = wasteCategoryRepository.findAll();
//
//            for (WasteCategory wasteCategory : wasteCategories) {
//                wasteCategoryDTOS.add(WasteCategoryDTO.builder()
//                        .id(wasteCategory.getId())
//                        .name(wasteCategory.getName())
//                        .build());
//            }
//
//            return wasteCategoryDTOS;
//        }
//    }
//
//    @Override
//    public WasteCategoryDTO getCategoryById(Long id) {
//        return null;
//    }
//
//    @Override
//    public WasteCategoryDTO createCategory(WasteCategoryDTO wasteCategoryDTO) {
//        WasteCategory wasteCategory = WasteCategory.builder()
//                .id(wasteCategoryDTO.getId())
//                .name(wasteCategoryDTO.getName())
//                .build();
//        wasteCategory = wasteCategoryRepository.save(wasteCategory);
//        return WasteCategoryDTO.builder()
//                .id(wasteCategory.getId())
//                .name(wasteCategory.getName())
//                .build();
//    }
//
//    @Override
//    public WasteCategoryDTO update(Long id, WasteCategoryDTO wasteCategoryDTO) {
//        WasteCategory wasteCategoryDB = wasteCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("WasteCategory not found"));
//
//        if (Objects.nonNull(wasteCategoryDTO.getName()) &&!"".equals(wasteCategoryDTO.getName())) {
//            wasteCategoryDB.setName(wasteCategoryDTO.getName());
//        }
//        if (Objects.nonNull(wasteCategoryDTO.getName()) &&!"".equals(wasteCategoryDTO.getName())) {
//            wasteCategoryDB.setName(wasteCategoryDTO.getName());
//        }
//        if (Objects.nonNull(wasteCategoryDTO.getName()) &&!"".equals(wasteCategoryDTO.getName())) {
//            wasteCategoryDB.setName(wasteCategoryDTO.getName());
//        }
//
//        wasteCategoryDB = wasteCategoryRepository.save(wasteCategoryDB);
//        return WasteCategoryDTO.builder()
//                .id(wasteCategoryDB.getId())
//                .name(wasteCategoryDB.getName())
//                .build();
//    }
//
//    @Override
//    public void deleteCategoryById(Long id) {
//        wasteCategoryRepository.deleteById(id);
//    }
//}
