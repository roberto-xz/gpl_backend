
package com.geoplace.gpl_api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<com.geoplace.gpl_api.models.UserModel,Long>{}
