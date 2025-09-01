package com.cheikh.diaspay2.entities;

import com.cheikh.diaspay2.enums.Status;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@Builder
public class ServiceRquests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requester_user_id", nullable = false)
    private Users requester;

    @ManyToOne
    @JoinColumn(name = "provider_user_id", nullable = false)
    private Users provider;

    @ManyToOne
    @JoinColumn(name = "parcel_parcel_id", nullable = false)
    private Parcels parcel;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "TEXT")
    private Status status = Status.EN_ATTENTE;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();



}
