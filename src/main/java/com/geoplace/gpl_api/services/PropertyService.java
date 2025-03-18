
package com.geoplace.gpl_api.services;

import com.geoplace.gpl_api.dtos.property.PropertyGetResponseDto;
import com.geoplace.gpl_api.mappers.PropertyMapper;
import com.geoplace.gpl_api.models.PropertyModel;
import com.geoplace.gpl_api.models.UserModel;
import com.geoplace.gpl_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geoplace.gpl_api.dtos.property.CreatePropertyRequestDto;
import com.geoplace.gpl_api.repositories.PropertyRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PropertyService {
    @Autowired
    private final PropertyRepository propertyRepository;

    @Autowired
    private final UserRepository userRepository;
    
    public Object createProperty(CreatePropertyRequestDto req) {
        PropertyMapper mapper = new PropertyMapper();
        PropertyModel property = mapper.dtoToModel(req);
        property.setUser(this.findAndValidUser("abac"));
        propertyRepository.save(property);
        return property;
    }

    public Object getAllProperty(){
        List<PropertyModel> properties = this.propertyRepository.findAll();
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




