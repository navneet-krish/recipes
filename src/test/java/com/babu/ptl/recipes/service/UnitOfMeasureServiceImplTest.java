package com.babu.ptl.recipes.service;

import com.babu.ptl.recipes.commands.UnitOfMeasureCommand;
import com.babu.ptl.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.babu.ptl.recipes.domain.UnitOfMeasure;
import com.babu.ptl.recipes.repositories.UnitOfMeasureRepository;
import com.babu.ptl.recipes.service.recipeservice.UnitOfMeasureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService unitOfMeasureService;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        unitOfMeasureService = new UnitOfMeasureServiceImpl(unitOfMeasureRepository,unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() {

        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1l);
        unitOfMeasures.add(unitOfMeasure);

        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure1.setId(2l);
        unitOfMeasures.add(unitOfMeasure1);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        Set<UnitOfMeasureCommand> unitOfMeasureCommands = unitOfMeasureService.listAllUoms();

        assertEquals(2, unitOfMeasureCommands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();
    }
}