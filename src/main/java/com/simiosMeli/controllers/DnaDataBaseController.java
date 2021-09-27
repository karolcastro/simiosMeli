/*package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.services.DnaDataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DnaDataBaseController {

    private final DnaDataBaseService dnaDataBaseService;

    @GetMapping(value = "/isSimian")
    public List<String[]> finAll() {
        return dnaDataBaseService.findAll();

    }
    @GetMapping(value = "/isSimian/{id}")
    public String[] findById(@PathVariable Long id) {
        return dnaDataBaseService.findById(id);
    }

    @PostMapping(value = "/isSimian/{id}")
    public String[] insert(@RequestBody String[] objDnaEntity) {
        return dnaDataBaseService.insert(objDnaEntity);
    }

    @DeleteMapping(value = "/isSimian/{id}")
    public void delete(@PathVariable Long id) {
        dnaDataBaseService.delete(id);
    }

    @PutMapping(value = "/isSimian/{id}")
    public String[] update(@PathVariable Long id, @RequestBody DnaEntity objDnaEntityUpdate) {
        return dnaDataBaseService.update(id, objDnaEntityUpdate);
    }
}
*/