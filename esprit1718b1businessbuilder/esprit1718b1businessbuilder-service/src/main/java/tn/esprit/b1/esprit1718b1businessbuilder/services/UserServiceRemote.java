package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {
	
	User login(String login, String password);
	Boolean findUser(String login, String password); 
	Boolean findByLogin(String login);
	Boolean findByPassword(String password) ;

   
}
