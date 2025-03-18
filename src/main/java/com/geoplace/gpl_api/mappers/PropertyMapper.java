package com.geoplace.gpl_api.mappers;

import com.geoplace.gpl_api.dtos.property.CreatePropertyRequestDto;
import com.geoplace.gpl_api.dtos.property.PropertyGetAllResponseDto;
import com.geoplace.gpl_api.dtos.property.PropertyGetResponseDto;
import com.geoplace.gpl_api.models.PropertyModel;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class PropertyMapper {
    public PropertyModel dtoToModel(CreatePropertyRequestDto dto) {
        PropertyModel output = new PropertyModel();
        AtomicInteger urls_count = new AtomicInteger();

        output.setCreatedDate(java.time.LocalDateTime.now());
        BeanUtils.copyProperties(dto, output, "id", "createdAt", "images", "user");
        return output;
    }

    public List<PropertyGetAllResponseDto> modelListToPropertyGetAllResponseDto(List<PropertyModel> models) {
        List<PropertyGetAllResponseDto>  cards = new ArrayList<>();

        models.forEach(model -> {
            PropertyGetAllResponseDto card_temp = new PropertyGetAllResponseDto();
            BeanUtils.copyProperties(model,card_temp);
            if (!model.getImages().isEmpty())
                card_temp.setCover(model.getImages().get(0).getImageUrl());
            cards.add(card_temp);
        });

        return  cards;
    }

    public PropertyGetResponseDto modelToPropertyGetResponseDto(PropertyModel model) {
        PropertyGetResponseDto resp = new PropertyGetResponseDto();
        BeanUtils.copyProperties(model,resp, "images");
        List<String> temp_images = new ArrayList<>();

        model.getImages().forEach(img ->{
            temp_images.add(img.getImageUrl());
        });

        resp.setCover(temp_images.get(0));
        resp.setImages(temp_images);
        return resp;
    }
}












