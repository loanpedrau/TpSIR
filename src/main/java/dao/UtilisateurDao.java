package dao;

import java.util.List;

import business.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur> {

    public UtilisateurDao() {
	super(Utilisateur.class);
    }
    
    public List<Utilisateur> getAllUsers(){
	List<Utilisateur> utilisateurs = entityManager.createNamedQuery("touslesutilisateurs", Utilisateur.class)
		.getResultList();
	return utilisateurs;
    }
}