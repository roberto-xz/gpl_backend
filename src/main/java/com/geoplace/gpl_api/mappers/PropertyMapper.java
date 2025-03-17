package com.geoplace.gpl_api.mappers;

import com.geoplace.gpl_api.dtos.property.CreatePropertyRequestDto;
import com.geoplace.gpl_api.dtos.property.PropertyCardResponseDto;
import com.geoplace.gpl_api.models.PropertyImageModel;
import com.geoplace.gpl_api.models.PropertyModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class PropertyMapper {
    public PropertyModel dtoToModel(CreatePropertyRequestDto dto) {
        PropertyModel output = new PropertyModel();
        AtomicInteger urls_count = new AtomicInteger();
        List<PropertyImageModel> images = new ArrayList<PropertyImageModel>();

        dto.getImageUrls().forEach(url -> {
            PropertyImageModel image = new PropertyImageModel();
            boolean isCover = urls_count.get() == 0;
            image.setIsCover(isCover);
            image.setImageUrl(url);
            image.setProperty(output);
            images.add(image);
            urls_count.getAndIncrement();
        });

        output.setCreatedDate(java.time.LocalDateTime.now());
        output.setImages(images);
        BeanUtils.copyProperties(dto, output, "id", "createdAt", "images", "user");
        return output;
    }

    public List<PropertyCardResponseDto> modelListToCardList(List<PropertyModel> models) {
        List<PropertyCardResponseDto>  cards = new ArrayList<>();
        if (models.isEmpty()) return null;

        models.forEach(model -> {
            PropertyCardResponseDto card_temp = new PropertyCardResponseDto();
            BeanUtils.copyProperties(model,card_temp);
            card_temp.setCover(model.getImages().get(0).getImageUrl());
            cards.add(card_temp);
        });

        return  cards;
    }
}












