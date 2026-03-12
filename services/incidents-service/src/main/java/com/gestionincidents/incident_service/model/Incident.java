package com.gestionincidents.incident_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    private String technicienId;

    // Ces blocs expliquent à Java ce que sont Statut et Priorite
    public enum Statut {
        OUVERT, EN_COURS, RESOLU
    }

    public enum Priorite {
        BASSE, MOYENNE, HAUTE
    }
}