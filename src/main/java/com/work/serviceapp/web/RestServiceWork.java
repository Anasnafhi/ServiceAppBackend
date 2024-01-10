package com.work.serviceapp.web;

import com.work.serviceapp.entities.Client;
import com.work.serviceapp.exceptions.ClientNotFoundException;
import com.work.serviceapp.service.IWorkService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class RestServiceWork {
    IWorkService iWorkService;


    @GetMapping("/clients")
    public List<Client> getClients(){
        return iWorkService.getClients() ;
    }

    @PostMapping("/clients/add")
    public void addClient(@RequestBody Client client){
        iWorkService.addClient(client);
    }
    @PatchMapping("/clients/update")
    public void updateClient(@RequestBody Client client){
        iWorkService.updateClient(client);
    }
    @DeleteMapping("/clients/delete/{id}")
    public void deleteClient(@PathVariable(name = "id") Long clienId)throws ClientNotFoundException {
        iWorkService.removeClient(clienId);
    }
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable(name = "id") Long id){
        return iWorkService.getClient(id) ;
    }


}
