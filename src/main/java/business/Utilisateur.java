package business;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType=DiscriminatorType.STRING)
@NamedQueries(
	{@NamedQuery(name="touslesutilisateurs", query="select u from Utilisateur u"),
	@NamedQuery(name="touslesutilisateursParNom", query="select u from Utilisateur u where u.name=:name")})
public class Utilisateur implements Serializable{

    String email;
    String name;
    List<Fiche> fiches;
    List<KanbanBoard> kanbanBoards;
    
    @Id
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany(mappedBy = "utilisateur")
    public List<Fiche> getFiches() {
        return fiches;
    }
    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
    
    @ManyToMany
    public List<KanbanBoard> getKanbanBoards() {
        return kanbanBoards;
    }
    public void setKanbanBoards(List<KanbanBoard> kanbanBoards) {
        this.kanbanBoards = kanbanBoards;
    }
    
    
}
