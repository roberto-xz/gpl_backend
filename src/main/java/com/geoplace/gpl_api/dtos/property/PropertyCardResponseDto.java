
package com.geoplace.gpl_api.dtos.property;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyCardResponseDto {
  private Long id;
  private String title;
  private String address;
  private String cover;
  private BigDecimal price;
  private Boolean isFavorited = false;

  private Short rooms;
  private Short bedrooms;
  private Short bathrooms;
  private Short kitchens;
}
