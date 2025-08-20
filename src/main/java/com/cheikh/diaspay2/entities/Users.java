//package com.cheikh.diaspay2.entities;
//
//import com.cheikh.diaspay2.enums.UserRole;
//import jakarta.persistence.*;
//import lombok.*;
//import org.locationtech.jts.geom.Point; // Correction: utiliser JTS Point
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "users")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//public class Users {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
//
//    @Column(name = "full_name") // Mapping correct pour la base de données
//    private String fullName; // camelCase pour Java
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @Column(name = "password_hash") // Mapping correct pour la base de données
//    private String passwordHash; // camelCase pour Java
//
//    @Enumerated(EnumType.STRING)
//    private UserRole role; // Correction: utiliser votre enum UserRole
//
//    private String phone;
//
//    @Column(columnDefinition = "geometry(Point,4326)") // Pour PostgreSQL + PostGIS
//    private Point location; // Correction: utiliser JTS Point
//
//    @Column(name = "years_of_experience") // Mapping correct pour la base de données
//    private Integer yearsOfExperience; // camelCase pour Java
//
//    @Column(name = "created_at", updatable = false) // Mapping correct
//    private LocalDateTime createdAt = LocalDateTime.now();
//}