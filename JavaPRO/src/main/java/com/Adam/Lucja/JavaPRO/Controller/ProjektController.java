package com.Adam.Lucja.JavaPRO.Controller;

import com.Adam.Lucja.JavaPRO.DTO.Request.ProjektRequest;
import com.Adam.Lucja.JavaPRO.DTO.Request.StudentRequest;
import com.Adam.Lucja.JavaPRO.DTO.Response.ProjektResponse;
import com.Adam.Lucja.JavaPRO.DTO.Response.StudentResponse;
import com.Adam.Lucja.JavaPRO.Service.ProjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projekty/")
public class ProjektController {
    @Autowired
    private ProjektService projektService;

    @GetMapping
    public ResponseEntity<List<ProjektResponse>> getAllProjekt(){
        return ResponseEntity.ok(projektService.getAllProjekty());
    }
    @GetMapping("{id}")
    public ResponseEntity<ProjektResponse> getProjekt(@PathVariable("id") Long id){
        return ResponseEntity.ok(projektService.getProjekt(id));
    }
    @PostMapping
    public ResponseEntity<ProjektResponse> createProjekt(@RequestBody ProjektRequest projektRequest){
        return ResponseEntity.ok(projektService.createProjekt(projektRequest));
    }
    @PutMapping("{id}")
    public ResponseEntity<ProjektResponse> updateProjekt(@RequestBody ProjektRequest projektRequest, @PathVariable("id") Long id) {
        return ResponseEntity.ok(projektService.updateProjekt(projektRequest, id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProjekt (@PathVariable Long id){
        projektService.deleteProjekt(id);
        return ResponseEntity.ok().build();
    }
}
