package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id; 
	
	@Column(name = "comment")
	private String comment;
	
	@Temporal(TemporalType.DATE)
	private Date datePost ;
	
	/* Association */
	
	@ManyToOne
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID")
	private Company companyC ; 
	
	
	@ManyToOne
	@JoinColumn(name="idForum",referencedColumnName="id")
	private Forum forumC ;

	@OneToMany (mappedBy="CommentUC")
	private List <Undercomment> undercomment;
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Company getCompanyC() {
		return companyC;
	}


	public void setCompanyC(Company company) {
		this.companyC = company;
	}


	public Forum getForumC() {
		return forumC;
	}


	public void setForumC(Forum forum) {
		this.forumC = forum;
	}


	public List<Undercomment> getUndercomment() {
		return undercomment;
	}


	public void setUndercomment(List<Undercomment> undercomment) {
		this.undercomment = undercomment;
	}


	public Date getDatePost() {
		return datePost;
	}


	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", datePost=" + datePost + "]";
	}


	public Comment() {
	}


	public Comment(String comment, Date datePost) {
		this.comment = comment;
		this.datePost = datePost;
	}
	
	/***************/
	
	
}
