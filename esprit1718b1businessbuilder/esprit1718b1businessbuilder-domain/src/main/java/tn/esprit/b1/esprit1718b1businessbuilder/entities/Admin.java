package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tab_Admin")

public class Admin extends User implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ADMIN_FIRST")
	private String firstname ;
	
	@Column(name = "ADMIN_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date birthdate ;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String name, String login, String password, String email) {
		super(name, login, password, email);
	}
	public Admin(String firstname, Date birthdate) {
		super();
		this.firstname = firstname;
		this.birthdate = birthdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Admin [firstname=" + firstname + ", birthdate=" + birthdate + ", toString()=" + super.toString() + "]";
	}
	
	




}
