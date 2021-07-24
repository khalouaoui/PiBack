package primeur.back.entities;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String fonction;
    private String equipe;
    @Lob
    private byte[] photo;
    @OneToMany(mappedBy ="user")
    private List<TechSkills> techSkills ;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


    public void setTechSkills(List<TechSkills> techSkills) {
        this.techSkills = techSkills;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getFonction() {
        return fonction;
    }

    public String getEquipe() {
        return equipe;
    }

    public byte[] getPhoto() {
        return photo;
    }

    
    public List<TechSkills> getTechSkills() {
        return techSkills;
    }
}
