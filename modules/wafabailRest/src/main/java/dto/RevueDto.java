package dto;

import java.util.Date;

public class RevueDto {
    private Long revueId;
    private String titre;
    private String details;
    private String lien;
    private Date dateCreation;

    public RevueDto() {
    }

    public RevueDto(Long revueId, String titre, String details, String lien, Date dateCreation) {
        this.revueId = revueId;
        this.titre = titre;
        this.details = details;
        this.lien = lien;
        this.dateCreation = dateCreation;
    }

    public Long getRevueId() {
        return revueId;
    }

    public void setRevueId(Long revueId) {
        this.revueId = revueId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
