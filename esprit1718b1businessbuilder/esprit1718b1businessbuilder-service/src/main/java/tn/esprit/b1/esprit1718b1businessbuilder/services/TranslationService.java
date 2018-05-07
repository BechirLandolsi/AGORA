package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProject;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Stateless
@LocalBean
public class TranslationService implements TranslationRemote {
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public List<String> translateComment(Date date) {
		List <String> words = new ArrayList<>();
		List <String> list = new ArrayList<>();

		String comment=find(date);
		 String[] a = comment.split(" ");    

	     for ( String i : a) {
	    	 words.add(i);    
	     }
	     
	     for (String j:words)
	     {
	   TypedQuery <String> q= em.createQuery("select t.anglais from Translation t where t.français=:j",String.class);
	   q.setParameter("j", j);
	  
	     list.add(q.getSingleResult());
	     }
		 
		return list;
	}

	@Override
	public String find(Date date) {

		String comment;

		 TypedQuery<String> k = em.createQuery("select co.commentBody from CommentProject co where co.commentprojectPK.commentDate=:date",String.class);
		 k.setParameter("date", date);
		 comment= k.getSingleResult();
		 return comment;
	}

}
