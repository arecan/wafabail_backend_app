package dto;

import java.io.Serializable;
import java.util.Date;

public class ArticleDto implements Serializable {

    private long articleId;
    private String titre;
    private String detail;
    private Date dateCreation;

    // Constructeurs
    public ArticleDto() {}

    public ArticleDto(long articleId, String titre, String detail, Date dateCreation) {
        this.articleId = articleId;
        this.titre = titre;
        this.detail = detail;
        this.dateCreation = dateCreation;
    }

    // Getters & Setters
    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
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
