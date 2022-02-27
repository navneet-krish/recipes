package com.babu.ptl.recipes.service.recipeservice;

import com.babu.ptl.recipes.commands.UnitOfMeasureCommand;
import com.babu.ptl.recipes.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
