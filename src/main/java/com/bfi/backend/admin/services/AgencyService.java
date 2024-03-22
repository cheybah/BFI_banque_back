package com.bfi.backend.admin.services;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.admin.repository.AgencyRepository;
import com.bfi.backend.client.entites.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    public Agency addAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency getAgencyById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agency not found with id: " + id));
    }
    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }
    public Agency updateAgency(Long id, Agency updatedAgencyData) {
        Agency agency = getAgencyById(id);
        agency.setName(updatedAgencyData.getName());
        agency.setVille(updatedAgencyData.getVille());
        agency.setAddress(updatedAgencyData.getAddress());
        agency.setTel(updatedAgencyData.getTel());
        agency.setEmail(updatedAgencyData.getEmail());
        // Update other fields as needed

        return agencyRepository.save(agency);
    }
}
