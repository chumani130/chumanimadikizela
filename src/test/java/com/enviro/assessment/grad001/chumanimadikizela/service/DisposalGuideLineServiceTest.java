package com.enviro.assessment.grad001.chumanimadikizela.service;

import com.enviro.assessment.grad001.chumanimadikizela.dto.DisposalGuideLineDTO;
import com.enviro.assessment.grad001.chumanimadikizela.model.DisposalGuideLine;
import com.enviro.assessment.grad001.chumanimadikizela.repository.DisposalGuideLineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DisposalGuideLineServiceTest {

    @InjectMocks
    private DisposalGuideLineServiceImpl disposalGuideLineService;

    @Mock
    private DisposalGuideLineRepository disposalGuideLineRepository;


    private List<DisposalGuideLine> disposalGuideLines;
    DisposalGuideLine disposalGuideLine;

    //Given Scenario
    @BeforeEach
    void initialDisposalGuideLine() {
        disposalGuideLine = DisposalGuideLine
                .builder()
                .Id(1L)
                .guideline("guideline")
                .build();
        disposalGuideLines = List.of(disposalGuideLine);
    }


    @Test
    void test_getAllGuideLines(){
      //When.. mock interacting external service e.g jpa
      when(disposalGuideLineRepository.findAll()).thenReturn(disposalGuideLines);

      //actual
        List<DisposalGuideLineDTO> getAllGuideLines =  disposalGuideLineService.getAllGuideLines();

        //Then
        assertEquals(1L, getAllGuideLines.get(0).getId());
    }

    @Test
    void test_getGuideLineById(){
        //Given
        Long generateId = 1L;

        //When.. mock interacting external service e.g jpa
        when(disposalGuideLineRepository.findById(generateId)).thenReturn(Optional.of(disposalGuideLine));

        //actual
        DisposalGuideLineDTO getGuideLineById =  disposalGuideLineService.getGuideLineById(generateId);

        //Then
        assertEquals(1L, getGuideLineById.getId());

    }

    @Test
    void test_createGuideLine() {
        //Given
        DisposalGuideLineDTO disposalGuideLineDTO = DisposalGuideLineDTO.builder()
                .guideline(disposalGuideLine.getGuideline())
                .build();
        //When
        when(disposalGuideLineRepository.save(DisposalGuideLine
                .builder()
                .guideline(disposalGuideLineDTO.getGuideline())
                .build()))
                .thenReturn(disposalGuideLine);

        //Then
        DisposalGuideLineDTO createGuideLine = disposalGuideLineService.createGuideLine(disposalGuideLineDTO);


        //assert
        assertEquals(disposalGuideLine.getId(), createGuideLine.getId());
        assertEquals(disposalGuideLine.getGuideline(), createGuideLine.getGuideline());
    }

    @Test
    void test_deleteGuideLine() {
        //Given

        //When

        //Then
    }

    @Test
    void test_updateGuideLine() {
        //Given

        //When

        //Then
    }
}
