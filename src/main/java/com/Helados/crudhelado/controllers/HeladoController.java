package com.Helados.crudhelado.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Helados.crudhelado.model.Helado;
import com.Helados.crudhelado.services.HeladoService;

@RestController
public class HeladoController {
    
private final HeladoService heladoService;

public HeladoController(HeladoService heladoService){
    this.heladoService = heladoService;
}


@GetMapping("/helado")
public List<Helado> getAllHelados(){
    return heladoService.getAllHelados();
}
@GetMapping("/helado/{id}")
public Helado getHeladoById(@PathVariable Long id) {
    return heladoService.getHeladoById(id);
}
@PostMapping("/helado")
public long  createHelados(@RequestBody Helado newHelado){
    return heladoService.createHelados(newHelado);
}
@PutMapping("/helado/{id}")
public void updateHelado(@PathVariable Long id, @RequestBody Helado updatedHelado) {
    heladoService.updateHelado(id, updatedHelado);
}

@DeleteMapping("/helado/{id}")
public void deleteHelado(@PathVariable Long id) {
    heladoService.deleteHelado(id);
}
}
