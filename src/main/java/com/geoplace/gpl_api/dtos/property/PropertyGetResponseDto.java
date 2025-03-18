
package com.geoplace.gpl_api.dtos.property;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PropertyGetResponseDto {
    private String title;
    private String address;
    private String cover;
    private BigDecimal price;
    private String description;
    private Short rooms;
    private Short bedrooms;
    private Short bathrooms;
    private Short kitchens;
    private List<String> images;
}
