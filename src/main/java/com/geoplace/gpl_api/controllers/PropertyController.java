
package com.geoplace.gpl_api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geoplace.gpl_api.dtos.property.CreatePropertyRequestDto;
import com.geoplace.gpl_api.services.PropertyService;

@RestController
@RequestMapping("/geoplace/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PropertyController {
    
    @Autowired
    PropertyService property;

    @PostMapping("/property")
    public Object create_(@RequestBody CreatePropertyRequestDto req) {
        return this.property.createProperty(req);
    }

    @GetMapping("/properties")
    public  Object listAll() {
        return this.property.getAllProperty();
    }
}
