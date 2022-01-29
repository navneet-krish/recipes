package com.babu.ptl.recipes.repositories;

import com.babu.ptl.recipes.domain.Category;
import com.babu.ptl.recipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
