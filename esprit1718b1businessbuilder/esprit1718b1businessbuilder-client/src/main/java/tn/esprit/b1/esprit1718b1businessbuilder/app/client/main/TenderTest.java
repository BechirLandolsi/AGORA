package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITender;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderCategoryService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceLocal;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;


public class TenderTest {

	public static void main(String[] args) throws NamingException, ParseException {
		
		//********************************************** TenderCategory*****************************************
		
		String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderCategoryService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderCategory" ; 
		Context context = new InitialContext();
		ITenderCategory proxyCategory = (ITenderCategory) context.lookup(jndiNameCategory);
		
		TenderCategory HelpDesk = new TenderCategory("HelpDesk");

		//proxyCategory.save(HelpDesk);
		
		//**********************************************TenderQualification************************************
		
		String jndiNameQualification ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderQualificationService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification" ; 
		ITenderQualification proxyQualification = (ITenderQualification) context.lookup(jndiNameQualification);
		
		TenderQualification SameCountry = new TenderQualification("Same Country");

		//proxyQualification.save(SameCountry);
		
		
		//******************************************** Test Logged User in adding Tender***************************
		String jndiNameTender="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITender";
		ITender proxyTender=(ITender)context.lookup(jndiNameTender);
		
		
		String jndiNameCompany ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
		CompanyServiceRemote proxyCompany = (CompanyServiceRemote) context.lookup(jndiNameCompany);
		
		
		Company loggedUser=(Company)proxyCompany.login("vermeglogin", "vermegpass");
		
		System.out.println(loggedUser);
		
		
		Tender tender = new Tender("Looking for Java web development Expert",
				new SimpleDateFormat("MM/dd/yyyy").parse("29/04/2018"), "I need someone who has expert level experiences in Java web development.", 
				new SimpleDateFormat("MM/dd/yyyy").parse("29/03/2018"));

		//tender.setCompanyTender(loggedUser);
		//tender.setCategory(HelpDesk);
		//proxyTender.save(tender);
		
	}

}
