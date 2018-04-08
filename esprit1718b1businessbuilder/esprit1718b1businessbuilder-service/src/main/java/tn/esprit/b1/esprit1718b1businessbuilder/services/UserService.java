package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;


@Stateless
public class UserService extends GenericDAO<User> implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		super(User.class);
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.password=:p", User.class)
					.setParameter("l", login)
					.setParameter("p", password)
					.getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}

	@Override
	public Boolean findUser(String login, String password) {
		User user = null;
		Boolean r = false ;
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l AND u.password=:p", User.class)
					.setParameter("l", login)
					.setParameter("p", password)
					.getSingleResult();
		} catch (Exception e) {
		}
		
		if (user != null){ r=true ;}
		
		return r;
			
	}
	
	@Override
	public void save(User u){
		entityManager.persist(u);
	}
	
	@Override
	public User update(User u) {
		return entityManager.merge(u);
	}

	@Override
	public Boolean findByLogin(String login) {
		User user = null;
		Boolean r = false ;
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.login=:l", User.class)
					.setParameter("l", login)
					.getSingleResult();
		} catch (Exception e) {
		}
		
		if (user != null) { r=true ;}
		
		return r;
	}
	
	@Override
	public Boolean findByPassword(String password) {
		User user = null;
		Boolean r = false ;
		try {
			user = entityManager.createQuery("SELECT u FROM User u WHERE u.password=:p", User.class)
					.setParameter("p", password)
					.getSingleResult();
		} catch (Exception e) {
		}
		
		if (user != null) { r=true ;}
		
		return r;
	}

	@Override
	public User find(Long i) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}

		

