package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Fiche;
import dao.FicheDao;

@WebServlet(name="ficheinfos",
urlPatterns={"/ficheinfos"})
public class FicheInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	FicheDao ficheDao = new FicheDao();
	List<Fiche> fiches = ficheDao.findAll();
	PrintWriter p = new PrintWriter(resp.getOutputStream());

	for(Fiche f : fiches) {
	    p.print("Fiche id :"+f.getId());
	    p.print("\n");
	    p.print("Libelle :"+f.getLibelle());
	    p.print("\n");
	    p.print("Lieu : "+f.getLieu());
	    p.print("\n");
	    p.print("Note :"+f.getNote());
	    p.print("---------------");
	    p.print("\n");
	    p.flush();
	}


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	FicheDao dao = new FicheDao();
	Fiche f = new Fiche();
	f.setLibelle(req.getParameter("libelle"));
	f.setLieu(req.getParameter("lieu"));
	f.setNote(req.getParameter("note"));
	dao.save(f);

	PrintWriter p = new PrintWriter(resp.getOutputStream());
	p.print("Enregistrement de la fiche suivante effectué : \n");
	p.print("Fiche id :"+f.getId());
	p.print("\n");
	p.print("Libelle :"+f.getLibelle());
	p.print("\n");
	p.print("Lieu : "+f.getLieu());
	p.print("\n");
	p.print("Note :"+f.getNote());
	p.print("---------------");
	p.print("\n");
	p.flush();

    }	
}
