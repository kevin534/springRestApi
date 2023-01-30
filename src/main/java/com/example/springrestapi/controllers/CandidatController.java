package com.example.springrestapi.controllers;

import com.example.springrestapi.models.Candidat;
import com.example.springrestapi.repositories.CandidatRepository;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/candidats",produces="application/json")
public class CandidatController {


    private final CandidatRepository candidatRepository;

    public CandidatController(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello wlcome in my API REST";
    }

    //TODO: réchercher tous les candidats
    @GetMapping("/getAll")
    public List<Candidat> findAll(){
        return candidatRepository.findAll();
    }

    //TODO: réchercher un candidat by id
    @GetMapping("/{id}")
    Candidat getOne(@PathVariable(name = "id", required = false) Candidat candidat){
        if(candidat == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidat Introuvable");
        }
        else {
            return candidat;
        }
    }

    //TODO: créer un candidat
    @PostMapping("/create")
    public ResponseEntity<Candidat> saveCandidat(@Valid @RequestBody Candidat candidat, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else{
            candidatRepository.save(candidat);
            return  new ResponseEntity<>(candidat,HttpStatus.CREATED);
        }
    }

    //TODO: modifier un candidat par id
    @PutMapping(value = "/{id}")
    public ResponseEntity<Candidat> update(@PathVariable(name = "id" ,required = false) Candidat candidat, @Valid  @RequestBody Candidat candidatUpdate, BindingResult bindingResult){
        if(candidat == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidat Introuvable");
        }
        else{
            if(bindingResult.hasErrors()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else{
               candidatUpdate.setId(candidat.getId());
               candidatRepository.save(candidatUpdate);
                return  new ResponseEntity<>(candidatUpdate,HttpStatus.OK);
            }
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOne(@PathVariable(name = "id",required = false) Candidat candidat)
    {
        if(candidat == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidat Introuvable");
        }
        else{
            candidatRepository.delete(candidat);
        }
    }

}

