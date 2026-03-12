package com.gestionincidents.incident_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionincidents.incident_service.model.Incident;
import com.gestionincidents.incident_service.service.IncidentService;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "http://localhost:3000")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.save(incident);
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.findAll();
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable Long id, @RequestBody Incident details) {
        // Logique de mise à jour simplifiée pour éviter les erreurs
        List<Incident> list = incidentService.findAll();
        Incident existing = list.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ID introuvable"));

        existing.setStatut(details.getStatut());
        return incidentService.save(existing);
    }
}