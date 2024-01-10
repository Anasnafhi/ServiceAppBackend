package com.work.serviceapp.repositories;

import com.work.serviceapp.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

    @Query("Select w from Worker w where w.serviceId = :w ")
    List<Worker> getWorkersByServiceId(@Param("w") Long serviceId);
}
