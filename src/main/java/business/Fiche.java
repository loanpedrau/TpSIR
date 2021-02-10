package business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fiche implements Serializable {

    long id;
    int position;
    String libelle;
    Date date_butoire;
    int requiredTime;
    String tags;
    String lieu;
    String url;
    String note;
    Utilisateur utilisateur;
    Section section;
    
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Date getDate_butoire() {
        return date_butoire;
    }
    public void setDate_butoire(Date date_butoire) {
        this.date_butoire = date_butoire;
    }
    public int getRequiredTime() {
        return requiredTime;
    }
    public void setRequiredTime(int requiredTime) {
        this.requiredTime = requiredTime;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
    @ManyToOne
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    @ManyToOne
    public Section getSection() {
        return section;
    }
    public void setSection(Section section) {
        this.section = section;
    }
    
}
