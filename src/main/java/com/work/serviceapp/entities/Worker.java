package com.work.serviceapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String zone;
    Long serviceId;
    String firsName;
    String lastName;
    Date dateNaissance;
    String phoneNumber;
    @Transient
    List<String> skills;
    @Transient
    Map<LocalDate,String> availability;
    @ManyToMany
    List<Service> services;


}
