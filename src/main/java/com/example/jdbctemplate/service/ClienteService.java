package com.example.jdbctemplate.service;

import java.util.List;

import com.example.jdbctemplate.Repository.ClienteRepositoryDAO;
import com.example.jdbctemplate.entities.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepositoryDAO repository;

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Integer id){
        return repository.findById(id);
    }

    public int insert(Cliente cliente){
        return repository.insert(cliente);
    }
}
