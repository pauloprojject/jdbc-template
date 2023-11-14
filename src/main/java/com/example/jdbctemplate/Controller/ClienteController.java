package com.example.jdbctemplate.Controller;

import java.util.List;

import com.example.jdbctemplate.entities.Cliente;
import com.example.jdbctemplate.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientess")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Cliente cliente){
        int cli = service.insert(cliente);
        return cli != 0 ? new ResponseEntity<String>("Cliente criado!", HttpStatus.CREATED)
                        : new ResponseEntity<String>("Erro cliente.", HttpStatus.BAD_REQUEST);
    }
}
