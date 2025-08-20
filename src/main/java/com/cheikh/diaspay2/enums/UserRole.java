package com.cheikh.diaspay2.enums;
import lombok.Getter;

@Getter
public enum UserRole {
    VENDEUR("Vendeur de terrains"),
    ACHETEUR("Acheteur de terrains"),
    GEOMATICIEN("Géomaticien - Services cartographiques"),
    INGENIEUR("Ingénieur - Services techniques"),
    ADMIN("Administrateur système");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }
}
