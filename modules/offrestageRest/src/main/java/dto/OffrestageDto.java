package dto;

import java.util.Date;

public class OffrestageDto {

    private Long stageId;
    private String titre;
    private String detail;
    private Date dateCreation;

    public OffrestageDto() {
    }

    public OffrestageDto(Long stageId, String titre, String detail, Date dateCreation) {
        this.stageId = stageId;
        this.titre = titre;
        this.detail = detail;
        this.dateCreation = dateCreation;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
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
