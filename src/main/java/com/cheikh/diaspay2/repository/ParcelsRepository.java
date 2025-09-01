package com.cheikh.diaspay2.repository;

import com.cheikh.diaspay2.entities.Parcels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelsRepository extends JpaRepository<Parcels, Long> {
    @Override
    List<Parcels> findAllParcels();
}
