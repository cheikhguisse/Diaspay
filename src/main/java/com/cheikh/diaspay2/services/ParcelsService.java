package com.cheikh.diaspay2.services;

import com.cheikh.diaspay2.entities.Parcels;


import java.util.List;
import java.util.Optional;

public interface ParcelsService {
    List<Parcels> getAllParcels();
    Parcels saveParcels(Parcels parcels);
    Optional<Parcels> getParcelsById(Long parcelsId);
    Optional<Parcels> updateParcels(Long parcelId, Parcels parcels);
    boolean deleteParcelsById(Long parcelsId);

}
