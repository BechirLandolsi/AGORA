package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.json.JSONObject;

import com.github.kevinsawicki.http.HttpRequest;

import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Comment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Forum;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Undercomment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Word;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ForumServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class AhmedMain {

	public static void main(String[] args) throws NamingException {
    /*    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
		Context context = new InitialContext();
		CompanyServiceRemote proxy = (CompanyServiceRemote) context.lookup(jndiName1);*/
		
	/*	Company c1 = new Company("Orange","orangelogin","orangepass","orange@gmail.com","CEO_Orange","Tunis",(long)71322111,"0T1","Telecommunication",4,"good","orange.jpg");
		Company c2 = new Company("Adidas","adidaslogin","adidaspass","adidas@gmail.com","CEO_adidas","France",(long)339585789,"0F1","Sport",5,"excellent","adidas.jpg");
		Company c3 = new Company("Vermeg","vermeglogin","vermegpass","vermeg@gmail.com","CEO_vermeg","France",(long)339585789,"0F12","IT",5,"excellent","vermeg.jpg");


		Company c4 = new Company("FIS","FISlogin","vermegpass","FIS@gmail.com","CEO_FIS","France",(long)339585789,"0F12","IT",5,"excellent","FIS.jpg");

		
		//proxy.add(c4);
	    //proxy.add(c2);
	    //proxy.add(c3);

		
		//System.out.println(proxy.findCompanyBysynonyme("passat"));*/
//System.out.println(getSentence("ben amri", "ben")) ;	    
	/*********************************************TESTCOMPANY*******************************************************************************************************************************************/
	   String jndiName ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
		 

	    Context context1 = new InitialContext();
		/*CompanyServiceRemote proxy1 = (CompanyServiceRemote) context.lookup(jndiName);
		//System.out.println();
		List<Object[]> list = proxy1.bestCompany();
	    for (Object[] o : list){
	    	Company company = (Company)o[1] ; 
	    	//System.out.println(company.toString());
	    	long count = (long)o[0] ; 
	    	//System.out.println(count);
	    }*/
	
 		//List <Compa}ny> list = new ArrayList<>() ;
 	 	//list = proxy1.findAllCompanyNames();
	    //System.out.println(list);    
	/**************************************************Reserche************************************************************************************************************************************/
 	 	
 	 	//Reserche reserche = new Reserche() ;
 	 	//reserche.setReserche("aaa");
 	 	//Company c =proxy1.findBy(30) ;
 	 	//proxy1.AddCompanyReserche(reserche,c);
 	/**********************************************Service*************************************************************************************/

 	 	//Service service = new Service () ;
 	 	//service.setName("car manufacturing");
 	 	//service.setName("wheel manufacturing");
 	 	//service.setName("furniture manufacturing");
 	 	//service.setName("steel manufacturing");
 	    //service.setName("smartphone manufacturing");
 	    //service.setName("simcard sale ");
 	 	//service.setName("merchandise  sale ");
 	    //service.setName("computer   sale ");
 	 	//                       proxy.ajouterService(service);
 	 	//proxy.affecterServiceACompany(30, 10);
 	 //	proxy.affecterServiceACompany(30, 12 );

 	 	//String jndiNameService="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote";
 	 	//ServiceServiceRemote proxyService = (ServiceServiceRemote)context1.lookup(jndiNameService);
	    
	   // Service service = new Service () ;
	    //service.setName("aabb");
 	 	/*service.setName("car manufacturing");
 	 	service.setName("wheel manufacturing");
 	 	service.setName("furniture manufacturing");
 	 	service.setName("steel manufacturing");
 	    service.setName("smartphone manufacturing");
 	    service.setName("simcard sale ");
 	 	service.setName("merchandise  sale ");
 	    service.setName("computer   sale ");*/
 	  // long  x= 0 ;
 			 //  x = proxyService.ajouterService(service);
 	   //Service s1 = proxyService.findService();
 	  // s1.setName("ahmed");
 	 // proxyService.editService(s1);
 	   //proxyService.removeService(19);
 	  // proxyService.affecterServiceACompany(4, 1);
 	 	/*proxy.affecterServiceACompany(30, 12 );

 	 	proxy.affecterServiceACompany(31, 13 );
 	 	proxy.affecterServiceACompany(31, 15 );
 	 	proxy.affecterServiceACompany(33, 2 );
 	 	proxy.affecterServiceACompany(31, 4 );
 	 	proxy.affecterServiceACompany(34, 13 );
 	 	proxy.affecterServiceACompany(35, 14 );*/
 	    //System.out.println( proxy1.findAllCompanyByService("orange"));
 	    //list.addAll(proxy1.findAllCompanyByService("sim"));
 	    //System.out.println(proxy1.findAllCompanyByService("orange"));
 	 	//System.out.println(proxy.ResercheListe(31));
	    
		//currencyConvertion("TND","EUR") ;
	    
	    
	    
	    
	    
	    
		
		String jndiNameF ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ForumService!tn.esprit.b1.esprit1718b1businessbuilder.services.ForumServiceRemote" ; 	
		String jndiNameC ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ;
	    String jndiNameP ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ;
	    
	    Context contextF = new InitialContext();
	    Context contextC = new InitialContext();
	    Context contextP = new InitialContext();

	    
	    ForumServiceRemote proxyF = (ForumServiceRemote) contextF.lookup(jndiNameF);
	    CompanyServiceRemote proxyC = (CompanyServiceRemote) contextC.lookup(jndiNameC) ; 
	    ProductServiceRemote proxyP = (ProductServiceRemote) contextP.lookup(jndiNameP);
        
	    Company c1 = proxyC.findBy((long)2);
	    Produit p1 = proxyP.findProduct(4) ;
	    
	    Company c2 = proxyC.findBy((long)3);
	    Produit p2 = proxyP.findProduct(3) ;
		
	    Forum forum1 = new Forum("looking for simcards for my employees", "i want to ask if this stock is a "
	    		+ "good or bad stock to give to my employees or not to communicate ?", p1 , c1) ;
	    Forum forum2 = new Forum("looking for wheels for my trucks", "i want to ask if this stock is a "
	    		+ "good or bad stock to repaire my trucks for delivering goods or not ?", p2 , c2) ;
	    
	   //Comment c = proxyF.findCommentById(1) ;

	   
	   
	 //  Undercomment uc = new Undercomment() ;
	   
	/*List<Undercomment> ucomments =   proxyF.getAllUnderCommentbyForm(2);
	List<Word> words =   proxyF.getAllWord();
	System.out.println(words.toString());
	   int x = 0 ;
	   for (Undercomment ucc : ucomments ) {
		   Pattern p = Pattern.compile("[a-zA-Z]+");
	         
	        Matcher m1 = p.matcher(ucc.getComment());
	        while (m1.find()) {
	        	 for (Word w : words ) {
	        	if (m1.group().equals(w.getWord())){
	        	   x = x + w.getPoint() ;
	        	   System.out.println(x);
	        	}
	        }
	   }*/
	 //  for (Produit p : proxyF.getRecommandation(2)){
	//	   System.out.println(p.getDescription());
	 //  }

	   
	                                     // proxyF.NoteUnderComment();
	  /* System.out.println(proxyF.NoteComment(2));
	   System.out.println(proxyF.NoteUnderComment(2));
	    
	  System.out.println( proxyF.NoteProduct(p1, proxyF.findForumById(2)) );
	  System.out.println(proxyF.getallCommentByForum(2).toString());
	  System.out.println(proxyF.getAllUnderCommentbyForm(2).toString());*/
	   //uc.setCommentUC(c);
	   //uc.setCompanyUC(c1);
	   
	   //proxyF.addUnderComment(uc);
		proxyF.ajouterForum(forum1) ;
		proxyF.ajouterForum(forum2) ;
	  //  System.out.println(proxyF.getAllForum());
 	 	//System.out.println(proxyF.nbrCommentForm(2));
	    //System.out.println(proxyF.nbrCompanyForum(2));
    }
/*	public static float currencyConvertion(String from,String to , float price)
	{
		String response = HttpRequest
				.get("https://v3.exchangerate-api.com/bulk/428d417084fe51418dc991a4/"+from)
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		//
		JSONObject status = jsonObject.getJSONObject("rates");
		Double eur = status.getDouble(to);
		return (float) (eur * price) ;
	} */
	//////////////////////////////////////FORUM////////////////////////////////////////////////////////////////////////////////
	

	
	
	
	
	}

