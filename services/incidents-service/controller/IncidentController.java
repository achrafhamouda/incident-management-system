package com.gestionincidents.incident_service.controller;

import com.gestionincidents.incident_service.model.Incident;
import com.gestionincidents.incident_service.model.Statut; // Import indispensable
import com.gestionincidents.incident_service.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "http://localhost:3000") 
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        // Force le statut à OUVERT si le frontend ne l'envoie pas
        if (incident.getStatut() == null) {
            incident.setStatut(Statut.OUVERT);
        }
        return incidentService.save(incident);
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.findAll();
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable Long id, @RequestBody Incident incidentDetails) {
        Incident incident = incidentService.findAll().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Incident introuvable"));
        
        // On force le statut RESOLU de l'Enum
        incident.setStatut(Statut.RESOLU);
        return incidentService.save(incident);
    }
}