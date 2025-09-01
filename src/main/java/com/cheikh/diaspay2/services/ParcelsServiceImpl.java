package com.cheikh.diaspay2.services;

import com.cheikh.diaspay2.entities.Parcels;
import com.cheikh.diaspay2.repository.ParcelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelsServiceImpl implements ParcelsService {

    private final ParcelsRepository parcelsRepository;

    @Autowired
    public ParcelsServiceImpl(ParcelsRepository parcelsRepository) {
        this.parcelsRepository = parcelsRepository;
    }

    @Override
    public List<Parcels> getAllParcels() {
        return parcelsRepository.findAllParcels();
    }

    @Override
    public Parcels saveParcels(Parcels parcels) {
        return parcelsRepository.save(parcels);
    }

//    @Override
//    public Parcels getParcelsById(Long parcelsId) {
//        Optional<Parcels> parcelsOptional = parcelsRepository.findById(parcelsId);
//        return parcelsOptional.orElse(null);
//    }
@Override
public Optional<Parcels> getParcelsById(Long parcelsId) {
    return parcelsRepository.findById(parcelsId);
}


    @Override
    public Optional<Parcels> updateParcels(Long parcelId, Parcels updated) {
        return parcelsRepository.findById(parcelId)
                .map(existing -> {
                    existing.setOwner(updated.getOwner());
                    existing.setTitle(updated.getTitle());
                    existing.setDescription(updated.getDescription());
                    existing.setPrice(updated.getPrice());
                    existing.setArea(updated.getArea());
                    existing.setGpsLocation(updated.getGpsLocation());
                    existing.setGeometry(updated.getGeometry());
                    existing.setLandTitle(updated.getLandTitle());
                    existing.setFileUrls(updated.getFileUrls());
                    return parcelsRepository.save(existing);
                });
    }

//    @Override
//    public void deleteParcelsById(Long parcelsId) {
//        parcelsRepository.deleteById(parcelsId);
//
//    }
@Override
    public boolean deleteParcelsById(Long parcelsId) {
        if (parcelsRepository.existsById(parcelsId)) {
            parcelsRepository.deleteById(parcelsId);
            return true;
        }
        return false;
    }

}
