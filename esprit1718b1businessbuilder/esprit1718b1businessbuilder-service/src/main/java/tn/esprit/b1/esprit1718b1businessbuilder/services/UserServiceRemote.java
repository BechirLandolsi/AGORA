package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {
   
}
