package com.gestionincidents.incident_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestionincidents.incident_service.model.Incident;
import com.gestionincidents.incident_service.repository.IncidentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    // Changé UUID en Long ici
    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    // Changé UUID en Long ici
    public Incident updateIncident(Long id, Incident incidentDetails) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident non trouvé"));
        incident.setTitre(incidentDetails.getTitre());
        incident.setDescription(incidentDetails.getDescription());
        incident.setPriorite(incidentDetails.getPriorite());
        incident.setStatut(incidentDetails.getStatut());
        incident.setTechnicienId(incidentDetails.getTechnicienId());
        return incidentRepository.save(incident);
    }

    // Changé UUID en Long ici
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}