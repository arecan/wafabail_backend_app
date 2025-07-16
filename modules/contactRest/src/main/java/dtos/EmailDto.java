package dtos;

public class EmailDto {

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String objet;
    private String message;

    public EmailDto(String nom, String prenom, String email, String telephone, String objet, String message) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.objet = objet;
        this.message = message;
    }

    public EmailDto() {
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getObjet() { return objet; }
    public void setObjet(String objet) { this.objet = objet; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
