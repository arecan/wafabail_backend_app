package dto;

import java.util.Date;

public class OffreemploiDto {

    private Long offreemploiId;
    private String titre;
    private String detail;
    private Date dateCreation;

    public OffreemploiDto() {
    }

    public OffreemploiDto(Long offreemploiId, String titre, String detail, Date dateCreation) {
        this.offreemploiId = offreemploiId;
        this.titre = titre;
        this.detail = detail;
        this.dateCreation = dateCreation;
    }

    public Long getOffreemploiId() {
        return offreemploiId;
    }

    public void setOffreemploiId(Long offreemploiId) {
        this.offreemploiId = offreemploiId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
