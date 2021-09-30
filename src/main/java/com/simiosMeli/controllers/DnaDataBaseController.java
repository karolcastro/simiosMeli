package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.services.DnaDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaDataBaseController {

    @Autowired
    private DnaDataBaseService dnaDataBaseService;

    @GetMapping
    public ResponseEntity<List<DnaEntity>> finAll() {
        List<DnaEntity> dnaList = dnaDataBaseService.findAll();
        return ResponseEntity.ok().body(dnaList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<DnaEntity> findById(@PathVariable Long id) {
        DnaEntity objDnaEntity = dnaDataBaseService.findById(id);
        return ResponseEntity.ok().body(objDnaEntity);
    }

    @PostMapping
    public ResponseEntity<DnaEntity> insert(@RequestBody DnaEntity objDnaEntity) {
        objDnaEntity = dnaDataBaseService.insert(objDnaEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDnaEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(objDnaEntity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dnaDataBaseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DnaEntity> update(@PathVariable Long id, @RequestBody DnaEntity objDnaEntityUpdate) {
        objDnaEntityUpdate = dnaDataBaseService.update(id, objDnaEntityUpdate);
        return ResponseEntity.ok().body(objDnaEntityUpdate);
    }
}
