
package com.geoplace.gpl_api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geoplace.gpl_api.models.PropertyModel;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyModel, Long>{}
