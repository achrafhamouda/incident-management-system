package com.gestionincidents.incident_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionincidents.incident_service.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    
    // Chercher par statut
    List<Incident> findByStatut(Incident.Statut statut);
    
    // Chercher par priorité
    List<Incident> findByPriorite(Incident.Priorite priorite);
    
    // Chercher par technicien (on utilise String car dans Incident.java c'est un String)
    List<Incident> findByTechnicienId(String technicienId);
}