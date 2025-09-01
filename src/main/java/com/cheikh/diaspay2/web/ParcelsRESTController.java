package com.cheikh.diaspay2.web;

import com.cheikh.diaspay2.entities.Parcels;
import com.cheikh.diaspay2.services.ParcelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parcels")
@CrossOrigin
public class ParcelsRESTController {

    private final ParcelsService parcelsService;

    @Autowired
    public ParcelsRESTController(ParcelsService parcelsService) {
        this.parcelsService = parcelsService;
    }

    @PostMapping
    public ResponseEntity<Parcels> save(@RequestBody Parcels parcels) {
        return ResponseEntity.ok(parcelsService.saveParcels(parcels));
    }

    @GetMapping
    public List<Parcels> getAllParcels() {
        return parcelsService.getAllParcels();
    }

    @GetMapping("/{idParcels}")
    public ResponseEntity<Parcels> getParcelsById(@PathVariable Long idParcels) {
        return parcelsService.getParcelsById(idParcels)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idParcels}")
    public ResponseEntity<Parcels> updateParcels(@PathVariable Long idParcels, @RequestBody Parcels updated) {
        return parcelsService.updateParcels(idParcels, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idParcels}")
    public ResponseEntity<Void> deleteParcels(@PathVariable Long idParcels) {
        parcelsService.deleteParcelsById(idParcels);
        return ResponseEntity.noContent().build();
    }


}
