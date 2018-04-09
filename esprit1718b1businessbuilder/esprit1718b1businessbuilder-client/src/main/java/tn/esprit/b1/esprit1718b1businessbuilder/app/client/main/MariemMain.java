package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;

public class MariemMain {
	public static void main(String[] args) throws NamingException, ParseException {
	
	String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
	Context context = new InitialContext();
	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
	
	User us = new User("name3", "login", "password", "email");
	User us2=new User("name4", "login", "password", "email");
	//proxyCategory.save(us);
	//us2=proxyCategory.update(us);
	
	/******************************/
    String jndiName ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
    Context contextt = new InitialContext();
    CompanyServiceRemote proxy = (CompanyServiceRemote) contextt.lookup(jndiName);
    
    Company companies = new Company();
    companies = proxy.findBy((long)20);
    System.out.println(companies);
       
    
	}
	

	
}
