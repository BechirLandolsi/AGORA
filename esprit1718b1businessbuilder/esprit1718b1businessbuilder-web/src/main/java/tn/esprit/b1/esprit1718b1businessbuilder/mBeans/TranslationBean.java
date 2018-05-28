package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProject;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CommentProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TranslationService;

@ManagedBean
@ViewScoped
public class TranslationBean {

	@ManagedProperty(value = "#{projectBean}")
	private ProjectBean projectBean ; 
	
	private String translatedcomment;
	private List<String> listTranslate;
	@EJB
	TranslationService translationservice;
	@EJB
	CommentProjectService commentprojetservice;

	
	/*public String ListCommentTranslated(Date date)
	{	
		List<String> body = translationservice.translateComment(date);
		
		StringBuilder sb = new StringBuilder();
		 for (String s : body)
	     {
	         sb.append(s);
	         sb.append(" ");
	     }
		 
		// CommentProject cp = new CommentProject();
		 this.translatedcomment=sb.toString();
		 //this.listcomment = commentprojectservice.AfficherCommentByProject(jib());
		// this.listcomment.add(cp);
		//return "/partnership?faces-redirect=true"; 
		return this.translatedcomment;
		
	}
	*/
	
	
	/*
public List<String> List(Date date)
	
	{	
		List<String> l = new ArrayList<>() ;
		for (int i=0;i<projectBean.getListcomment().size();i++)
		{
			
			      l.add(" ");
				
			
		}
		this.listTranslate=l;
		
		//String a=this.ListCommentTranslated(date);
		//System.out.println("//////////////////"+this.translatedcomment);
		if (this.translatedcomment!="")
		{ 
			for(CommentProject cp : projectBean.getListcomment())
			{
				if (cp.getCommentprojectPK().getCommentDate()==date)
				{
					l.set(projectBean.getListcomment().indexOf(cp), this.ListCommentTranslated(date));
					this.listTranslate=l;
				}
		   
		  // System.out.println("///////////////"+this.listTranslate);
		   return this.listTranslate;
		}
		}
		
		return this.listTranslate;
	
		
	}
	*/
	
	public String ListCommentTranslated(Date date)
	{	/*List<String> l = new ArrayList<>() ;
		for(CommentProject cp : projectBean.getListcomment())
			{
		      l.add(" ");
			}
		this.listTranslate =l ;*/
		
		List<String> body = translationservice.translateComment(date);
		StringBuilder sb = new StringBuilder();
		 for (String s : body)
	     {
	         sb.append(s);
	         sb.append(" ");
	     }
		String translated =sb.toString();
		this.translatedcomment= translated;
		/*System.out.println(this.translatedcomment);
		for(CommentProject cp : projectBean.getListcomment()){
			if (cp.getCommentprojectPK().getCommentDate()==date){
				this.listTranslate.set(projectBean.getListcomment().indexOf(cp), translated);
			}
		}*/
		
		return this.translatedcomment;
		
		
		
	}
	

	
	
	
	
	public String getTranslatedcomment() {
		return translatedcomment;
	}

	public void setTranslatedcomment(String translatedcomment) {
		this.translatedcomment = translatedcomment;
	}

	public ProjectBean getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public List<String> getListTranslate() {
		/*for(CommentProject cp : projectBean.getListcomment()){
			this.listTranslate.add(" ");
		}*/
		return listTranslate;
	}

	public void setListTranslate(List<String> listTranslate) {
		this.listTranslate = listTranslate;
	}
	
	
	

	
}
