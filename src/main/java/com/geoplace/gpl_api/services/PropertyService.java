
package com.geoplace.gpl_api.services;

import com.geoplace.gpl_api.dtos.property.PropertyGetResponseDto;
import com.geoplace.gpl_api.mappers.PropertyMapper;
import com.geoplace.gpl_api.models.PropertyImageModel;
import com.geoplace.gpl_api.models.PropertyModel;
import com.geoplace.gpl_api.models.UserModel;
import com.geoplace.gpl_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geoplace.gpl_api.dtos.property.CreatePropertyRequestDto;
import com.geoplace.gpl_api.repositories.PropertyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PropertyService {
    @Autowired
    private final PropertyRepository propertyRepository;

    @Autowired
    private final UserRepository userRepository;
    private final String UPLOAD_DIR = "/home/roberto-xz/Desktop/gpl_frontend/public/img/properties/";

    public Object createProperty(CreatePropertyRequestDto req,MultipartFile[] images) {
        PropertyMapper mapper = new PropertyMapper();
        List<PropertyImageModel> imagesModel = new ArrayList<>();
        PropertyModel property = mapper.dtoToModel(req);

        // salvado as images no servidor
        for (MultipartFile image: images) {
            if (!image.isEmpty()) {
                try {
                    PropertyImageModel imageModel = new PropertyImageModel();
                    String image_name = UUID.randomUUID().toString().substring(10) + ".jpg";
                    Path fileDestine = Paths.get(UPLOAD_DIR + image_name);
                    Files.copy(image.getInputStream(), fileDestine, StandardCopyOption.REPLACE_EXISTING);
                    imageModel.setImageUrl(image_name);
                    imageModel.setProperty(property);
                    imagesModel.add(imageModel);
                }
                catch (IOException e) {return null;}
            }
        }
        property.setImages(imagesModel);
        property.setUser(this.findAndValidUser("abac"));
        return propertyRepository.save(property);
    }

    public Object getAllProperty(){
        List<PropertyModel> properties = this.propertyRepository.findAll();
        if (properties.isEmpty()) return  null;
        PropertyMapper mapper = new PropertyMapper();
        return mapper.modelListToPropertyGetAllResponseDto(properties);
    }

    public Object getProperty(Long propertyId){
        Optional<PropertyModel> property = this.propertyRepository.findById(propertyId);

        if (property.isPresent()) {
            PropertyMapper mapper = new PropertyMapper();
            PropertyGetResponseDto resp = mapper.modelToPropertyGetResponseDto(property.get());
            return resp;
        }
        return null;
    }

    private UserModel findAndValidUser(String userToken) {
        Optional<UserModel> user = this.userRepository.findById(1L);
        UserModel userModel = user.isPresent() ? user.get() : null;
        return userModel;
    }
}




