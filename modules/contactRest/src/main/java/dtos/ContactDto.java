package dtos;

public class ContactDto {
    private String nom;

    private String telephone;

    public ContactDto(String nom, String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }

    public ContactDto() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
