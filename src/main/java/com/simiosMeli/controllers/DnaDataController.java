package com.simiosMeli.controllers;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.services.DnaDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaDataController {

    @Autowired
    private DnaDataBaseService dnaDataBaseService;

    @GetMapping
    public ResponseEntity<List<String[]>> finAll() {
        List<String[]> dnaList = dnaDataBaseService.findAll();
        return ResponseEntity.ok().body(dnaList);
    }
    @GetMapping(value = "/{id}")
    public Long findById(@PathVariable Long id) {
        Long objDnaEntity = dnaDataBaseService.findById(id);
        return dnaDataBaseService.findById(objDnaEntity);
    }

    @PostMapping
    public ResponseEntity<DnaDto> insert(@RequestBody DnaDto objDnaEntity) {
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
    public ResponseEntity<DnaDto> update(@PathVariable Long id, @RequestBody DnaDto objDnaEntityUpdate) {
        objDnaEntityUpdate = dnaDataBaseService.update(id, objDnaEntityUpdate);
        return ResponseEntity.ok().body(objDnaEntityUpdate);
    }
}
