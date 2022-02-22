package com.babu.ptl.recipes.converters;

import com.babu.ptl.recipes.commands.UnitOfMeasureCommand;
import com.babu.ptl.recipes.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setDescription(source.getDescription());
        unitOfMeasureCommand.setId(source.getId());
        return unitOfMeasureCommand;
    }
}
