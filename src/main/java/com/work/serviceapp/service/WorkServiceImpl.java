package com.work.serviceapp.service;

import com.work.serviceapp.entities.Client;
import com.work.serviceapp.entities.Service;
import com.work.serviceapp.entities.Worker;
import com.work.serviceapp.exceptions.ClientNotFoundException;
import com.work.serviceapp.repositories.ClientRepository;
import com.work.serviceapp.repositories.ServiceRepository;
import com.work.serviceapp.repositories.WorkerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;


@Transactional
@org.springframework.stereotype.Service
@AllArgsConstructor

public class WorkServiceImpl implements IWorkService {
    ClientRepository clientRepository;
    ServiceRepository serviceRepository;
    WorkerRepository workerRepository;

    @Override
    public void addClient(Client c) {
        List<Service> services = serviceRepository.getServicesByClientId(c.getId());
        if(services!=null){
        c.setServices(services);
        clientRepository.save(c);}
    }

    @Override
    public void removeClient(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id).get();
        if(client!=null){
         clientRepository.delete(client);}
        else throw new ClientNotFoundException("Client not found");

    }

    @Override
    public Client updateClient(Client c) {

        Client client = clientRepository.findById(c.getId()).get();
        if(client==null) throw new RuntimeException("can't update client");
        client.setFirsName(c.getFirsName());
        client.setLastName(c.getLastName());
        client.setDateNaissance(c.getDateNaissance());
        client.setServices(c.getServices());
        return clientRepository.save(client);

    }

    @Override
    public Client getClient(Long id) {
        Client client =clientRepository.findById(id).get();
        if(client == null) throw new RuntimeException("Can't find null client");
        return client  ;
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    //Workers

    @Override
    public void addWorker(Worker w) {
        List<Service> services = serviceRepository.getServicesByWorkerId(w.getId());
        w.setServices(services);
        workerRepository.save(w);
    }

    @Override
    public void removeWorker(Long id) {
        Worker worker = workerRepository.findById(id).get();
        if(worker==null) throw new RuntimeException("can't remove null worker");
         workerRepository.delete(worker);
    }

    @Override
    public Worker updateWorker(Worker w) {
        Worker worker=workerRepository.findById(w.getId()).get();
        if(worker==null) throw new RuntimeException("can't update null worker");
        worker.setServices(w.getServices());
        worker.setZone(w.getZone());
        worker.setSkills(w.getSkills());
        worker.setAvailability(w.getAvailability());

        return workerRepository.save(worker);
    }

    @Override
    public Worker getWorker(Long id) {
        return workerRepository.findById(id).get();
    }

    @Override
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public List<Worker> getWorkersByService(Long serviceId) {
        return workerRepository.getWorkersByServiceId(serviceId);
    }

    @Override
    public void addService(Service s) {
            serviceRepository.save(s);
    }

    @Override
    public Service removeService(Long id) {
        Service service = serviceRepository.findById(id).get();
        if(service==null) throw new RuntimeException("can't remove null service");

        return service;
    }

    @Override
    public Service updateService(Service s) {
        Service service = serviceRepository.findById(s.getId()).get();
        if(service == null) throw new RuntimeException("can't update null service");
        service.setName(s.getName());
        service.setClient(s.getClient());
        service.setWorker(s.getWorker());
        return service ;
    }

    @Override
    public List<Service> getServiceByName(String name) {
        return serviceRepository.getServicesByNameContains(name);
    }

    @Override
    public List<Service> getServices() {
        return serviceRepository.findAll();
    }
}
