package com.cheikh.diaspay2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "parcels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parcels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parcelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false) // Correction: nom standard
    private Users owner;

    @Column(nullable = false, length = 150)
    private String title;

    private String description;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;

    @Column(precision = 10, scale = 2)
    private BigDecimal area;

    // Pour PostgreSQL avec PostGIS
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point gpsLocation;

    @Column(columnDefinition = "geometry(Polygon,4326)")
    private Polygon geometry;

    private String landTitle;

    @ElementCollection
    @CollectionTable(
            name = "parcel_files",
            joinColumns = @JoinColumn(name = "parcel_id")
    )
    @Column(name = "file_url")
    private List<String> fileUrls;

    @Column(name = "created_at", updatable = false) // Mapping correct
    private LocalDateTime createdAt = LocalDateTime.now();
}