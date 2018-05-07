package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "undercomment")
public class Undercomment implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;
	
	@Column(name = "undercomment")
	private String comment;
	@Temporal(TemporalType.DATE)
	private Date datePost ;
/* Association */
	
	@ManyToOne
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID")
	private Company companyUC ; 
	
	
	@ManyToOne
	@JoinColumn(name="idComment",referencedColumnName="id")
	private Comment CommentUC ;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Company getCompanyUC() {
		return companyUC;
	}


	public void setCompanyUC(Company companyUC) {
		this.companyUC = companyUC;
	}


	public Comment getCommentUC() {
		return CommentUC;
	}


	public void setCommentUC(Comment commentUC) {
		CommentUC = commentUC;
	}


	public Date getDatePost() {
		return datePost;
	}


	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}


	@Override
	public String toString() {
		return "Undercomment [id=" + id + ", comment=" + comment + ", datePost=" + datePost + "]";
	}


	public Undercomment() {
	}


	public Undercomment(Long id, String comment, Date datePost) {
		this.id = id;
		this.comment = comment;
		this.datePost = datePost;
	}


	public Undercomment(String comment, Date datePost) {
		this.comment = comment;
		this.datePost = datePost;
	}


	public Undercomment(String comment, Date datePost, Comment commentUC ) {
		this.comment = comment;
		this.datePost = datePost;
		CommentUC = commentUC;
		
	}
	
	
	
}
