package jpa;

import java.util.ArrayList;
import java.util.List;

import business.Admin;
import business.Fiche;
import business.KanbanBoard;
import business.Section;
import business.Utilisateur;
import dao.FicheDao;
import dao.KanbanDao;
import dao.SectionDao;
import dao.UtilisateurDao;

public class JpaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

	FicheDao ficheDao = new FicheDao();
	KanbanDao kanbanDao = new KanbanDao();
	KanbanBoard kb = new KanbanBoard();
	kb.setName("first kanban");
	kanbanDao.save(kb);
	
	Section section1 = new Section();
	section1.setName("section1");
	section1.setKanbanBoard(kb);
	SectionDao sectionDao = new SectionDao();
	sectionDao.save(section1);
	
	Section section1Bis = new Section();
	section1Bis.setName("section1");
	section1Bis.setKanbanBoard(kb);
	sectionDao.save(section1Bis);

	Section section2 = new Section();
	section2.setName("section2");
	section2.setKanbanBoard(kb);
	sectionDao.save(section2);
	
	Utilisateur user1 = new Utilisateur();
	user1.setEmail("email@gmail.com");
	user1.setName("user1");
	
	List<KanbanBoard> kanbans = new ArrayList<>();
	kanbans.add(kb);
	user1.setKanbanBoards(kanbans);
	UtilisateurDao userDao = new UtilisateurDao();
	userDao.save(user1);
	
	List<Fiche> fiches = new ArrayList<>();
	for(int i =0; i<5; i++) {
	    Fiche f = new Fiche();
	    f.setLibelle("ficheNumero"+i);
	    f.setLieu("lieu"+i);
	    f.setNote("note ....");
	    f.setPosition(i);
	    f.setSection(section1);
	    f.setUtilisateur(user1);
	    ficheDao.save(f);
	}
	
	Admin admin = new Admin();
	admin.setEmail("admin@gmail.com");
	admin.setLevel(5);
	admin.setName("admin");
	admin.setKanbanBoards(kanbans);
	userDao.save(admin);
	
	List<Section> sections = sectionDao.getSectionWithName("section1");
	System.out.println("Id of sections with name 'section1'");
	for(Section s : sections) {
	    System.out.println("ID : "+s.getId());
	}
	
	System.out.println("Id of sections with name 'section1' or 'section2' ");
	List<Long> idSectionsWithName = sectionDao.getIdOfSectionWithNames("section1","section2");
	for(Long id : idSectionsWithName) {
	    System.out.println("ID : "+id);
	}
	
	List<Utilisateur> users = userDao.getAllUsers();
	System.out.println("Tous les utilisateurs : ");
	for(Utilisateur user : users) {
	    System.out.println("Nom : "+user.getName()+" email : "+user.getEmail());
	}
	
    }

}
