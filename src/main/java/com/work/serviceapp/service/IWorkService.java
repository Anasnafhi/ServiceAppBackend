package com.work.serviceapp.service;

import com.work.serviceapp.entities.Client;
import com.work.serviceapp.entities.Service;
import com.work.serviceapp.entities.Worker;
import com.work.serviceapp.exceptions.ClientNotFoundException;


import java.util.List;


public interface IWorkService {
    void addClient(Client c);
    void removeClient(Long id) throws ClientNotFoundException;
    Client updateClient(Client c);
    Client getClient(Long id);
    List<Client> getClients();

    //Workers
    void addWorker(Worker w);
    void removeWorker(Long id);
    Worker updateWorker(Worker w);
    Worker getWorker(Long id);
    List<Worker> getWorkers();


    List<Worker> getWorkersByService(Long serviceId);

    //Services
    void addService(Service s);
    Service removeService(Long id);
    Service updateService(Service w);
    List<Service> getServiceByName(String name);
    List<Service> getServices();
}
