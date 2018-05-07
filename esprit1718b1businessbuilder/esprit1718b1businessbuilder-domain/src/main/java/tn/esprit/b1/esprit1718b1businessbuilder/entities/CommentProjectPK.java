package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommentProjectPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long ProjectId;
	private Long CompanyId;
	private Date commentDate;	
	
	public CommentProjectPK() {
		super();
	}

	

	public CommentProjectPK(Long projectId, Long companyId, Date commentDate) {
		super();
		ProjectId = projectId;
		CompanyId = companyId;
		this.commentDate = commentDate;
	}

	





	public CommentProjectPK(Date commentDate) {
		super();
		this.commentDate = commentDate;
	}



	public CommentProjectPK(Long projectId, Long companyId) {
		super();
		ProjectId = projectId;
		CompanyId = companyId;
	}



	public Long getProjectId() {
		return ProjectId;
	}


	public void setProjectId(Long projectId) {
		ProjectId = projectId;
	}


	public Long getCompanyId() {
		return CompanyId;
	}


	public void setCompanyId(Long companyId) {
		CompanyId = companyId;
	}


	

	public Date getCommentDate() {
		return commentDate;
	}



	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CompanyId == null) ? 0 : CompanyId.hashCode());
		result = prime * result + ((ProjectId == null) ? 0 : ProjectId.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentProjectPK other = (CommentProjectPK) obj;
		if (CompanyId == null) {
			if (other.CompanyId != null)
				return false;
		} else if (!CompanyId.equals(other.CompanyId))
			return false;
		if (ProjectId == null) {
			if (other.ProjectId != null)
				return false;
		} else if (!ProjectId.equals(other.ProjectId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "CommentProjectPK [ProjectId=" + ProjectId + ", CompanyId=" + CompanyId + "]";
	}

	

	
	
}
