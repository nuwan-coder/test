package com.icbt.weddingplanner.serviceuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceUserRepository extends JpaRepository<ServiceUser,Long> {

    @Query(value = "select * from service_user su where su.price_per_plate between ?1 and ?2",nativeQuery = true)
    public List<ServiceUser> getSuitableUser(Double lowerPirce, Double maxPrice);

}
