package com.work.serviceapp.repositories;

import com.work.serviceapp.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {


    @Query("Select s from Service s where s.name like :x")
    List<Service> getServicesByNameContains(@Param(value="x") String name);
    @Query("Select s from Service s where s.client.id = :k")

    List<Service> getServicesByClientId(@Param("k") Long clientId);
    @Query("Select s from Service s where s.worker.id = :k")

    List<Service> getServicesByWorkerId(@Param("k") Long workerId);
}
