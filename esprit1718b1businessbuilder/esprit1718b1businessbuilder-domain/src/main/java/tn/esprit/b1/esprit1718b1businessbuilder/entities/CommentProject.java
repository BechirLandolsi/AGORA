package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tab_commentproject")
public class CommentProject implements Serializable {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private CommentProjectPK commentprojectPK;
	
	@ManyToOne
	@JoinColumn(name="CompanyId",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company CompanyComment;
	
	
	@ManyToOne
	@JoinColumn(name="ProjectId",referencedColumnName="ProjectId",insertable=false,updatable=false)
	private Project projectComment;
		
	
	@Column(name = "commentBody")
	private String commentBody;
	
	@Column(name = "state")
	private boolean state;
	
	
	
	public CommentProject() {
		super();
	}



	public CommentProject(CommentProjectPK commentprojectPK, Company companyComment, Project projectComment,
		 String commentBody, boolean state) {
		super();
		this.commentprojectPK = commentprojectPK;
		CompanyComment = companyComment;
		this.projectComment = projectComment;
		this.commentBody = commentBody;
		this.state = state;
	}



	public CommentProjectPK getCommentprojectPK() {
		return commentprojectPK;
	}



	public void setCommentprojectPK(CommentProjectPK commentprojectPK) {
		this.commentprojectPK = commentprojectPK;
	}



	public Company getCompanyComment() {
		return CompanyComment;
	}



	public void setCompanyComment(Company companyComment) {
		CompanyComment = companyComment;
	}



	public Project getProjectComment() {
		return projectComment;
	}



	public void setProjectComment(Project projectComment) {
		this.projectComment = projectComment;
	}



	public String getCommentBody() {
		return commentBody;
	}



	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}



	public boolean isState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "CommentProject [commentprojectPK=" + commentprojectPK + ", CompanyComment=" + CompanyComment
				+ ", projectComment=" + projectComment + ", commentDate=" + ", commentBody=" + commentBody
				+ ", state=" + state + "]";
	}

	

	
	
}