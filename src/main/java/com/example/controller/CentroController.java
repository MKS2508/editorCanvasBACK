package com.example.controller;
import java.util.*;


import com.example.modelo.centro.Centro;
import com.example.services.CentroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.modelo.aula.Aula;
import com.example.services.AulaService;

@RestController
@CrossOrigin(origins = "http://localhost:4300", maxAge = 3600)
public class CentroController {

    @Autowired
    private CentroService cs;

    @Autowired
    private AulaService as;

    @GetMapping("/centros")
    public ResponseEntity<?> allProducts() {
        List<Centro> centros = cs.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(centros);
    }

    @GetMapping("/centro/{id}")
    public ResponseEntity<?> getCentro(@PathVariable String id) {
        Optional<Centro> centroOptional = cs.findById(id);
        if(centroOptional.isPresent()) {
            Centro centro = centroOptional.get();
            return ResponseEntity.status(HttpStatus.OK).body(centro);
        }else {
            throw new LienzoNoEncontradoException(id);
        }
    }

    @PostMapping("centro")
    public ResponseEntity<?> postCentro(@RequestBody Centro nuevoCentro) {
        Centro c=  nuevoCentro;
        cs.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @PutMapping("/centro/{idCentro}")
    public ResponseEntity<?>  putLienzo(@PathVariable String idCentro, @RequestBody Centro centro) {
        Centro editadoCentro = new Centro();
        System.out.println(centro.getAulas());
        editadoCentro = cs.findById(idCentro).get();
        editadoCentro.setAulas(centro.getAulas());
        cs.edit(editadoCentro).toString();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/centro/{id}")
    public ResponseEntity<?>  deleteCanvas(@PathVariable String id) {
        cs.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/centro/{idCentro}/aula/{idAula}")
    public ResponseEntity<?> asociarTutor (@PathVariable String idCentro, @PathVariable String idAula) {

        Aula a = new Aula();
        Centro c = new Centro();
        Set<Aula> aulas = new HashSet<>();
        Optional<Aula> aulaOptional = as.findById(idAula);
        Optional<Centro> centroOptional = cs.findById(idCentro);



        if(centroOptional.isPresent()){
             c = centroOptional.get();
            if(aulaOptional.isPresent()){
                a = aulaOptional.get();
                aulas = c.getAulas();
                aulas.add(a);
                c.setAulas(aulas);
                cs.edit(c);
            } else {
                throw new LienzoNoEncontradoException(idAula);
            }
        } else {
            throw new LienzoNoEncontradoException(idCentro);
        }
//        a.setTutor(t);
//        as.edit(a).toString();
        return ResponseEntity.status(HttpStatus.OK).body(c);

    }



}
