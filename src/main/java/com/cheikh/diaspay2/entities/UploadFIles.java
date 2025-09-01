package com.cheikh.diaspay2.entities;

import com.cheikh.diaspay2.enums.ServiceType;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "uploade_files")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class UploadFIles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceRquests request;

    private String fileUrl;

    private LocalDateTime uploadAt = LocalDateTime.now();
}
