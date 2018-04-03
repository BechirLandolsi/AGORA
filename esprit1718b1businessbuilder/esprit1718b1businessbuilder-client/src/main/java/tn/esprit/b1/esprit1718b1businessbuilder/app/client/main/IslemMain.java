package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

public class IslemMain {
	public static void main(String[] args) throws NamingException, ParseException {
	
		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ; 
		Context context = new InitialContext();
		
		EventServiceRemote proxy = (EventServiceRemote) context.lookup(jndiName1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date =dateFormat.parse("31/12/2018");
		Event e= new Event("Foire Samsung","Tunis","Mobile",false,date);
		proxy.save(e);
		Event event2=proxy.find((long)4);
		System.out.println(e);
		//proxy.removeEvent((long)15);
		//System.out.println("suppression succeded");
		
		String format = "dd/MM/yy H:mm:ss"; 

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date da = new java.util.Date(); 

		System.out.println( formater.format( date ) ); 
	}
}
