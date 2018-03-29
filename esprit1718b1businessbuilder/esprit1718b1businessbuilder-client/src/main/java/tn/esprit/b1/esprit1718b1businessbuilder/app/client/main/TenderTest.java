package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification;


public class TenderTest {

	public static void main(String[] args) throws NamingException {
		
		//********************************************** TenderCategory*****************************************
		
		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderCategoryService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderCategory" ; 
		Context context = new InitialContext();
		ITenderCategory proxy = (ITenderCategory) context.lookup(jndiName1);
		
		TenderCategory HelpDesk = new TenderCategory("HelpDesk");

		//proxy.save(HelpDesk);
		
		//**********************************************TenderQualification************************************
		
		String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderQualificationService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification" ; 
		ITenderQualification proxy2 = (ITenderQualification) context.lookup(jndiName2);
		
		TenderQualification SameCountry = new TenderQualification("Same Country");

		//proxy2.save(SameCountry);
	}

}
