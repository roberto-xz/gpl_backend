
package com.geoplace.gpl_api.models;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "properties")
public class PropertyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    private LocalDateTime createdDate;
    private String type;
    private String contractType;
    private String title;
    private String description;
    private Boolean isDeleted = false;
    private Integer viewsCount = 0;
    private Integer favoritesCount = 0;
    
    // Localização
    private String region;
    private String state;
    private String city;
    private String neighborhood;
    private String address;
    private Double latitude;
    private Double longitude;

    // Detalhes
    private Short rooms;     // salas
    private Short bedrooms;  // quartos
    private Short bathrooms; // banheiros
    private Short kitchens;  // cozinhas
    private Short parkingSpaces;
    private Double area;

    private BigDecimal price;
    private BigDecimal pricePerMonth;
    private BigDecimal pricePerDay;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyImageModel> images;
}
