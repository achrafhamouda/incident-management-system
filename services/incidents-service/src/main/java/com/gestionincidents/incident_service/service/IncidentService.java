package com.gestionincidents.incident_service.service;

import com.gestionincidents.incident_service.model.Incident;
import com.gestionincidents.incident_service.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;

    // Ajout de la méthode save() pour correspondre à ton Controller
    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    // Ajout de la méthode findAll() pour correspondre à ton Controller
    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    // Garde createIncident pour la compatibilité
    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Optional<Incident> getIncidentById(UUID id) {
        return incidentRepository.findById(id);
    }

    public Incident updateIncident(UUID id, Incident incidentDetails) {
        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident non trouvé"));
        incident.setTitre(incidentDetails.getTitre());
        incident.setDescription(incidentDetails.getDescription());
        incident.setPriorite(incidentDetails.getPriorite());
        incident.setStatut(incidentDetails.getStatut());
        incident.setTechnicienId(incidentDetails.getTechnicienId());
        return incidentRepository.save(incident);
    }

    public void deleteIncident(UUID id) {
        incidentRepository.deleteById(id);
    }
}