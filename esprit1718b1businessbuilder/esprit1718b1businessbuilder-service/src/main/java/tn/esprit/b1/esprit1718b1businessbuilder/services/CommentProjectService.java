package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProject;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProjectPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.PartnershipPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

import org.json.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;

@Stateless
@LocalBean

public class CommentProjectService implements CommentProjectRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public void addCommentOnProject(String body, CommentProjectPK pk,CommentProject comment) {
		
		comment.setCommentprojectPK(pk);
		comment.setCommentBody(body);
		
		em.persist(comment);
		
	}

	
	@Override
	public List<CommentProject> AfficherCommentByProject(Project p) {
		
		TypedQuery <CommentProject> k = em.createQuery("select c from CommentProject c where c.projectComment=:p",CommentProject.class);
		k.setParameter("p", p);
		List <CommentProject> listcomments = k.getResultList();
		
		return listcomments;
		
	}


	@Override
	public List<CommentProject> findCommentProjectId(Project project) {
		//CommentProject comment = new CommentProject();
		TypedQuery <CommentProject> k = em.createQuery("select c from CommentProject c where c.projectComment=:project",CommentProject.class);
		k.setParameter("project", project);
		List <CommentProject> list=k .getResultList();

		return list;
	}


	@Override
	public Date ConvertDate(Date date) {
		 Calendar date1 = new GregorianCalendar();
		 date1.setTime(date);
		 Date dater =date1.getTime();
		 return dater;
	}


	@Override
	public CommentProject findCommentByDate(Date date) {
		CommentProject com = new CommentProject();
		TypedQuery <CommentProject> k = em.createQuery("select c from CommentProject c where c.commentprojectPK.commentDate=:date",CommentProject.class);
		k.setParameter("date",date);
		com= k.getSingleResult();
		
		return com;
	}


	

	

		
	


}
