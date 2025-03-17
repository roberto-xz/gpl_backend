
package com.geoplace.gpl_api.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "property_images")
public class PropertyImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private Boolean isCover = false;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @JsonIgnore // Evita a recursão infinita
    private PropertyModel property;
}
