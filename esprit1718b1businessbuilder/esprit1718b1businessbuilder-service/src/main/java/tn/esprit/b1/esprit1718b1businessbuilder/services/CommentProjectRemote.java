package tn.esprit.b1.esprit1718b1businessbuilder.services;


import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProject;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProjectPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Remote
public interface CommentProjectRemote {
	
		public void addCommentOnProject(String body, CommentProjectPK pk,CommentProject comment);
		
		public List<CommentProject> findCommentProjectId(Project project);
		
		public List<CommentProject> AfficherCommentByProject(Project p);
		
		public Date ConvertDate (Date date);
		
		public CommentProject findCommentByDate(Date date);
		
		//public int CommentNumberByProject()
		
		

	}


