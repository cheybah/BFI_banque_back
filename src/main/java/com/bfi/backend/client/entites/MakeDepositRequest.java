package com.bfi.backend.client.entites;


public class MakeDepositRequest {

    private Double montant;
    private String ribDepotCompteSource;
    private String depotOption;
    private String motif;

    // Constructeur par défaut (obligatoire pour la désérialisation JSON)
    public MakeDepositRequest() {
    }

    // Getters et setters
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getRibDepotCompteSource() {
        return ribDepotCompteSource;
    }

    public void setRibDepotCompteSource(String ribDepotCompteSource) {
        this.ribDepotCompteSource = ribDepotCompteSource;
    }

    public String getDepotOption() {
        return depotOption;
    }

    public void setDepotOption(String depotOption) {
        this.depotOption = depotOption;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
