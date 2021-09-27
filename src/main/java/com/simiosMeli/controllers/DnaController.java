package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @GetMapping
    public ResponseEntity<List<DnaEntity>> finAll() {
        List<DnaEntity> dnaList = dnaService.findAll();
        return ResponseEntity.ok().body(dnaList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<DnaEntity> findById(@PathVariable Long id) {
        DnaEntity objDnaEntity = dnaService.findById(id);
        return ResponseEntity.ok().body(objDnaEntity);
    }

    @PostMapping
    public ResponseEntity<DnaEntity> insert(@RequestBody DnaEntity objDnaEntity) {
        objDnaEntity = dnaService.insert(objDnaEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDnaEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(objDnaEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dnaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DnaEntity> update(@PathVariable Long id, @RequestBody DnaEntity objDnaEntityUpdate) {
        objDnaEntityUpdate = dnaService.update(id, objDnaEntityUpdate);
        return ResponseEntity.ok().body(objDnaEntityUpdate);
    }
}
