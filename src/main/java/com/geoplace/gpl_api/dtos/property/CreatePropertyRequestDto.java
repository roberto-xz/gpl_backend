
package com.geoplace.gpl_api.dtos.property;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreatePropertyRequestDto {
    private String userToken;
    private String title;
    private String type;
    private String contractType;
    private String description;
    private String state;
    private String city;
    private String neighborhood;
    private String address;
    private Double latitude;
    private Double longitude;
    private BigDecimal price;
    private BigDecimal pricePerMonth;
    private BigDecimal pricePerDay;

    private Short rooms;     // salas
    private Short bedrooms;  // quartos
    private Short bathrooms; // banheiros
    private Short kitchens;  // cozinhas
    private Short parkingSpaces;
    private Double area;

    private List<String> imageUrls;
}
