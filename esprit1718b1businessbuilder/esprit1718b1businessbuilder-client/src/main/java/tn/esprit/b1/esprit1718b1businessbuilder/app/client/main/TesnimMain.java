package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProject;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CommentProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TranslationRemote;

import com.google.api.GoogleAPI;
import com.google.api.client.util.DateTime;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import com.google.common.base.Joiner;
import com.google.api.Files;
import junit.framework.TestCase;

import org.junit.Test;

import com.google.api.GoogleAPI;

import java.io.File;

import javassist.Translator;

public class TesnimMain {

	public static void main(String[] args) throws Exception {
		
        String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
		
        String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
       
        String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/BilanService!tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote" ; 

        String jndiName4 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/PartnershipService!tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote" ; 

        String jndiName5 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CommentProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.CommentProjectRemote" ; 

        String jndiName6 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TranslationService!tn.esprit.b1.esprit1718b1businessbuilder.services.TranslationRemote" ; 

        
		Context context = new InitialContext();
		
		//CompanyServiceRemote proxy = (CompanyServiceRemote) context.lookup(jndiName2);
		
		//System.out.println("projets sont: "+proxy.getProjectsByCompany(16));
		
		//System.out.println(proxy.getProjectsByCompany(10));
		
		//System.out.println(proxy.FindBySector("Sport"));
		
		
		//Context context2 = new InitialContext();
		
	//	ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName1);
		
		//Company c =proxy.findBy((long)2);
		
		//System.out.println(c);
		//System.out.println(c.getId());
		
		//List <Integer> nbr = new ArrayList<>();
		
		//nbr=proxy2.countProjectsByCompanyName("Vermeg");
		
	//	System.out.println(nbr.get(0));
		
		//long i=proxy2.CountUnstableProjects();
		//System.out.println(i);
		
		
		///List <Project> p = new ArrayList<>();
		//p=proxy2.getRateByCompany(c);
		
		//System.out.println(p);
		
		//System.out.println(proxy.FindBySectorButCompany(c.getId(), "Sport"));

/*******************************************************************************************************************************/		
		
		/*List<Project> p = new ArrayList<>();
		
		ProjectRemote proxy1 = (ProjectRemote) context.lookup(jndiName1);
		p = proxy1.findProjectById((long)13);
		if (p.isEmpty())
		{
			System.out.println("Project not found");
		}
		else {
			p.get(0).setName("test Edit");
			proxy1.Edit(p.get(0));
			System.out.println("Edit validé");
			}
		*/
		
/**************************************************************************************************************/		
		//ProjectRemote proxy1 = (ProjectRemote) context.lookup(jndiName1);
		//BilanRemote proxy2 = (BilanRemote) context.lookup(jndiName2);
		
		//List<Bilan> b = new ArrayList<>();
		
		//b=proxy2.findBilan((long) 21);

		//List<Project> p = new ArrayList<>();
		
		//p = proxy1.findProjectById((long)15);
		//proxy1.delete(p.get(0));
		
		//PartnershipRemote proxy2 = (PartnershipRemote) context.lookup(jndiName4);
		
		//System.out.println(proxy2.PartnershipNonConfirm((long)3));
		
		
		//System.out.println(proxy2.findPartnershipById((long)16));
		
		
	 
		 ProjectRemote proxy2 = (ProjectRemote) context.lookup(jndiName1);
		//System.out.println(proxy2.searchForProject("888",(long)3));
		
		
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date a = dateFormat.parse("05/05/2018");
		Date b = dateFormat.parse("05/06/2018");*/
	
		//System.out.println((b.getTime() - a.getTime()) / (1000 * 60 * 60 * 24));
		
		

		 
		// Calendar creation = Calendar.getInstance();
		// Calendar fin = Calendar.getInstance();

		// creation.setTime(proxy2.findProjectById((long)25).get(0).getCreationDate());
		  
		 // fin.setTime(proxy2.findProjectById((long)25).get(0).getCreationDate());

		  
		 //  System.out.println((fin.getTime().getTime()-creation.getTime().getTime())/ (1000 * 60 * 60 * 24));
		//System.out.println((fin.getTime().getTime()-creation.getTime().getTime())/ (1000 * 60 * 60 * 24));
		
		    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			//LocalDate localDate = LocalDate.now();
			//System.out.println(dtf.format(localDate)); 
			//System.out.println((ca2.getTime().getTime()-ca2.getTime().getTime())/ (1000 * 60 * 60 * 24));
		//  Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		  
		/*  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			dtf.format(localDate);*/
		  
			//now.setTime(date);
			//System.out.println(now);
			//System.out.println((ca1.getTime().getTime()-ca2.getTime().getTime())/ (1000 * 60 * 60 * 24));
		 // Project p = proxy2.findProjectById((long)28).get(0);
		 // System.out.println(proxy2.AvancementProject(p));
			
			/*
			Calendar creation = new GregorianCalendar();
			 Calendar fin = new GregorianCalendar();
			 Calendar now = new GregorianCalendar();*/

			// creation.setTime(p.getCreationDate());
			// fin.setTime(p.getFinishDate());
			 
			
			 // double projectdays = (int) ((fin.getTime().getTime()-creation.getTime().getTime())/ (1000 * 60 * 60 * 24));
			
			  //System.out.println(projectdays);
			  
			  //LocalDate localDate = LocalDate.now();
			 // System.out.println(localDate.getChronology());
			  //Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			 //
			 // now.setTime(date);
			 /// startdays= (int) ((now.getTime().getTime()-creation.getTime().getTime())/ (1000 * 60 * 60 * 24));
			 //System.out.println(date);
			 // System.out.println(now.getTime().getTime());
			 // System.out.println(creation.getTime().getTime());

			  
			  //float tauxAvancement =(float) ((startdays/projectdays))*100;
			 // System.out.println(tauxAvancement);
			  
			 // Company c =proxy.findBy((long)3);
			  //System.out.println(proxy2.getProjectsNameByCompanyjsf(c.getId()).size());
			 // System.out.println(proxy2.getProjectsNameByCompanyjsf(c.getId()));

			// System.out.println(proxy2.AvancementDesProjetsByCompanyjsf(c.getId()).size());
			
			  //System.out.println(proxy2.AvancementProject(p));
			 // Project p = proxy2.findProjectById((long)25).get(0);
			//  CommentProjectRemote proxycomment = (CommentProjectRemote) context.lookup(jndiName5);
			 // System.out.println(proxycomment.findCommentProjectId(p).getCommentDate());
			// Date dateee = proxycomment.findCommentProjectId(p).getCommentDate();
			 // Calendar date2 = new GregorianCalendar();
			//  date2.setTime(dateee);
			// Date dater =date2.getTime();
			 //System.out.println(((now.getTime().getTime()-dater.getTime())/ (1000 * 60 * 60 * 24)));

			 //DateFormat dateFormattt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//	Date datett = new Date();
			//	System.out.println(datett);
			 
			 //System.out.println(dater);
	
				// System.out.println(c5);
			//System.out.println(proxy2.searchForProject("Sport", c5));
			
				// char data[] = {'a', 'b', 'c'};
			   //  String str = new String(data);
			    // System.out.println(str);
			
			
				
			  //   String string="TESNIM DAHMENI hey";
			   // System.out.println(string.substring(0, 1));
			  /* List<String> letters=new ArrayList<>();
			    for(int i=0;i<string.length();i++)
			    {
			    	String f = string.substring(i,i+1);
			    	letters.add(f);	
			    }
			     //System.out.println("letters list "+letters);
			     String word=null;
			     int j = 0;
			     List<Integer> l1= new ArrayList<>();
			     List<String> l2= new ArrayList<>();
			     l1.add(0);
			     for (int i=0;i<letters.size();i++)
			     {	 
			    	// for (String j : letters)
			    	 if (letters.get(i).equals(" "))
			    	 {  j=i+1;
			    	 	
			    		 l1.add(j);
			    		 
			    	 } 	 
			     }
			     
			     l1.add(letters.size()+1);
			    
			     //System.out.println("l1 list "+l1);
			     
			      for(int i=0;i<letters.size();i++)
			      {
			    	  
			      }*/
			     
			    /* for(int i=0;i<letters.size()-2;i++)
			     {
			    	l2.addAll(letters.subList(l1.get(i),Math.abs(l1.get(i+1)-1)));
			     }*/
			    	/*
			   	for (int k=0;k<l1.size()-1;k++)
			    	{
			    		
			    		//l2.addAll(letters.subList(l1.get(i),Math.abs(l1.get(i+1)-1)));
			    	}
			    	//System.out.println(l2);
			    	//System.out.println(n);
			    	//String str3 = new String(t);
			    	//System.out.println(str3);
			     }
			     //String str3 = new String(t);
			    	//System.out.println(t);
			    //	System.out.println(str3);
			    // System.out.println(l1);

			*/     
			/*	
				List<String> words=new ArrayList<>();
				 String stringg="TESNIM DAHMENI hey";
			     String[] arr = stringg.split(" ");    

			     for ( String ss : arr) {
			    	 words.add(ss);
			         
			     }
			     
			     String strName = "name";
			     String[] strArray = new String[] {strName};
			     //System.out.println(strArray[0]);
			     
			     //System.out.println(words);
			     
			     Project p = proxy2.findProjectById((long)25).get(0);
			     CommentProjectRemote proxycomment = (CommentProjectRemote) context.lookup(jndiName5);
			     List<CommentProject> coo = new ArrayList<>();
			     coo=proxycomment.findCommentProjectId(p);
			    // System.out.println(coo.get(0).getCommentBody());
			     TranslationRemote proxy6 = (TranslationRemote) context.lookup(jndiName6);
			     
			     System.out.println(proxy6.translateComment(coo.get(0).getCommentprojectPK().getCommentDate()));
			     
			  //   System.out.println(proxy6.translateComment());
			     
			     ArrayList<String> list = new ArrayList<String>();
			     list.add("one");
			     list.add("two");
			     list.add("three");

			     StringBuilder sb = new StringBuilder();
			     for (String s : list)
			     {
			         sb.append(s);
			         sb.append(" ");
			     }

			   //System.out.println(sb);
			   String ma =new String(sb);
			  //  System.out.println(ma);
			     
			    */ 
		 
		 Project p = proxy2.findProjectById((long)25).get(0);
	     CommentProjectRemote proxycomment = (CommentProjectRemote) context.lookup(jndiName5);
	     List<CommentProject> coo = new ArrayList<>();
	     coo=proxycomment.findCommentProjectId(p);
	    //System.out.println(coo.get(0).getCommentprojectPK().getCommentDate());
	     TranslationRemote proxy6 = (TranslationRemote) context.lookup(jndiName6);
	    Date date = coo.get(0).getCommentprojectPK().getCommentDate();
	     //System.out.println(date);
	    // System.out.println(proxy6.translateComment(date));
		 
	    System.out.println(proxy6.find(date));
		 
	}

	
}
