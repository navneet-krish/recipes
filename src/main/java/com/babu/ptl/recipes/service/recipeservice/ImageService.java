package com.babu.ptl.recipes.service.recipeservice;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(long recipeId, MultipartFile file );
}
