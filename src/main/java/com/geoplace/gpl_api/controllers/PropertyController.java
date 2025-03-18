
package com.geoplace.gpl_api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geoplace.gpl_api.dtos.property.CreatePropertyRequestDto;
import com.geoplace.gpl_api.services.PropertyService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/geoplace/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PropertyController {
    @Autowired
    PropertyService property;

    @PostMapping(value = "/property", consumes = "multipart/form-data")
    public Object create_(
            @RequestPart("data") CreatePropertyRequestDto req,
            @RequestParam("images") MultipartFile[] images
    ) {
        return this.property.createProperty(req,images);
    }

    @GetMapping("/properties" )
    public  Object listAll() {
        return this.property.getAllProperty();
    }

    @GetMapping("/property/{property_id}")
    public Object getProperty(@PathVariable Long property_id){
        return this.property.getProperty(property_id);
    }
}
