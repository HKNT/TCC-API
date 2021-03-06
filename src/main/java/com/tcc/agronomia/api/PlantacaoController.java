package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.Plantacao.Plantacao;
import com.tcc.agronomia.domain.Plantacao.PlantacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/plantil")
public class PlantacaoController {
    @Autowired
    private PlantacaoService service;

    @GetMapping
    public ResponseEntity<Iterable<Plantacao>> get(){
        return new ResponseEntity<>(service.getPlantilDados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Plantacao>> get(@PathVariable("id") long id){
        Optional<Plantacao> plantil = service.getPlantilDadosById(id);

        if(plantil.isPresent()){
            return ResponseEntity.ok(service.getPlantilDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(service.getUsuariosById(id));
    }
    @Secured("ROLE_ADMIN")
    @PostMapping
    public String post(@RequestBody Plantacao plantil){
        Plantacao u = service.insert(plantil);
        return "Plantação salva com sucesso: "+u.getId();
    }
    @Secured("ROLE_ADMIN")
    @PutMapping("{id}")
    public String put(@RequestBody Plantacao plantil, @PathVariable long id){
        Plantacao user = service.update(plantil, id);
        return "Plantação atualizada com sucesso: "+user.getId();
    }
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return service.delete(id);
    }
}