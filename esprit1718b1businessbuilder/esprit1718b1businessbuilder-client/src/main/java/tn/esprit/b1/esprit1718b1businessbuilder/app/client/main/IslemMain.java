package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

public class IslemMain {
	
	public static void main(String[] args) throws NamingException, ParseException {
	
		//*************************************************************************
		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ; 
		Context context = new InitialContext();
		EventServiceRemote proxy = (EventServiceRemote) context.lookup(jndiName1);
		
		//*************************************************************************
		
		String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
		Context context2 = new InitialContext();
		CompanyServiceRemote proxy2 = (CompanyServiceRemote) context.lookup(jndiName2);
		
		
		
		String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/InvitationService!tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote" ; 
		Context context3 = new InitialContext();
		InvitationServiceRemote proxy3 = (InvitationServiceRemote) context.lookup(jndiName3);
		//*************************************************************************
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date data =dateFormat.parse("12/05/2018");
		Date dat1 =dateFormat.parse("10/05/2018");
		Date dat2 =dateFormat.parse("09/05/2018");
		Date dat3 =dateFormat.parse("12/05/2018");
		Date dat4 =dateFormat.parse("31/05/2018");
		Event e = new Event("Vermeg Opening", "Germany , Berlin", "Software","Company Opening",true,true,data);
		Event e1 = new Event("Orange milestones", "Tunisia ,Tunis", "Telecommunications","ompany milestones",true,true,dat1);
		Event e2 = new Event("Delice Event", "Germany , frankfurt", "Food","Product launch",false,true,dat2);
		Event e3 = new Event("Wevioo Fest", "Libya , tripoli", "Software","Appreciation Event",true,true,dat3);
		Event e4 = new Event("Said chocolate tasting", "France , Paris", "Food","Product launch",true,false,dat4);
		List<Event> eventlist = new ArrayList<Event>();
		List<Company> companies = new ArrayList<Company>();
		List<Event> eventreminder = new ArrayList<Event>();
		eventlist.add(e);
		eventlist.add(e1);
		eventlist.add(e2);
		eventlist.add(e3);
		eventlist.add(e4);
		eventreminder=proxy.EventReminder(eventlist);
		System.out.println(eventreminder);
		    /*ObservableList<Event> event_l
		///************************************************************************
	/*	Company com1 = new Company("Orange","orangelogin","orangepass","orange@gmail.com","CEO_Orange","Tunis",(long)71322111,"0T1","Telecommunication",4,"good","orange.jpg");
		Company loggedUser=(Company)proxy2.login("vermeglogin", "vermegpass");
		System.out.println(loggedUser);
		System.out.println(loggedUser.getId());*/
		//proxy2.add(com1);

		//System.out.println(loggedUser.getEvents());
		//System.out.println(com1.getId());
		//************************************************************************
		/*List<Event> all = new ArrayList<Event>();
	
		
	    all=proxy.findEventByCompany((long)8);
	    System.out.println(all);
	   // upcomingonly=proxy.ArchiveOldEvents();:::::::::::::::::::::::::::::::::::::::::::::
	   
	    for (Event event : upcomingonly) 
	    {System.out.println(event);}
		///************************* Adding Test **********************************
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date datep =dateFormat.parse("31/12/2018");
		Event e= new Event("Foire Samsung","Tunis","Mobile",true,datep);
		e.setCompany_organizer(proxy2.findBy((long)8));
		proxy.save(e);
        proxy3.InviteCompanyToAnEvent(8, 155);
	
		
	    all=proxy.findEventByCompany((long)8);
	    System.out.println(all);*/
		
		//**************************** Find Event By Id ****************************
		
		//***************************** Removing Event ******************************
		//proxy.delete(proxy.find((long)4));
		//System.out.println("suppression succeded");
		
		
		//******************************* Date Tests ********************************
	/*	// today Date
		String format = "dd/MM/yy H:mm:ss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date da = new java.util.Date(); 
		//System.out.println( formater.format( datep ) ); 
		
		
	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(da);
	    // return number of today in the whole year
	    int today=c1.get(Calendar.DAY_OF_YEAR);
	    // return the actual year
	    int year = c1.get(Calendar.YEAR);
	    
	    System.out.println(year);
	    System.out.println(da);
	    //**************************************************************************
	    
	    //******************************Searching event by name Test ****************
	    List<Event> eventlist = new ArrayList<Event>();
	    eventlist=proxy.findEventByName("company opening");
	    for (Event event : eventlist) 
	    {System.out.println(event);}
	    
	   //******************************Searching event by Date Test ****************
	    List<Event> eventlista = new ArrayList<Event>();
        eventlista=proxy.findEventByDate(datep);
        for (Event event : eventlista) 
        {System.out.println(event);}*/
    }
}
	
	

