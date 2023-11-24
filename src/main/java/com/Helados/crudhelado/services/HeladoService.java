package com.Helados.crudhelado.services;

import com.Helados.crudhelado.model.Helado;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Helados.crudhelado.repositories.HeladoRepository;

@Service
public class HeladoService {
    private final HeladoRepository repository;

    public HeladoService(HeladoRepository repository){
        this.repository = repository;
    }

    public List<Helado> getAllHelados(){
        return repository.getAllHelados();
    }

    public Helado getHeladoById(Long id) {
        return repository.getHeladoById(id);
    }

    public long createHelados(Helado newhelado){
        return repository.createHelados(newhelado);
    }

    public void updateHelado(Long id, Helado updatedHelado) {
        repository.updateHelado(id, updatedHelado);
    }

    public void deleteHelado(Long id) {
        repository.deleteHelado(id);
    }

}
