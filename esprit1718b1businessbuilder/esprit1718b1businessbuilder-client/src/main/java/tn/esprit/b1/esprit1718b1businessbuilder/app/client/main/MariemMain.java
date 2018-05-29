package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contact;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;

import tn.esprit.b1.esprit1718b1businessbuilder.services.UserService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;

public class MariemMain {
	public static void main(String[] args) throws NamingException, SocketException {
	
	/*String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
	Context context = new InitialContext();
	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
	
	User us = new User("name3", "login", "password", "email");
	User us2=new User("name4", "login", "password", "email");
	//proxyCategory.save(us);
	//us2=proxyCategory.update(us);*/
	
	/******************************/
    String jndiName ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
    Context contextt = new InitialContext();
    CompanyServiceRemote proxy = (CompanyServiceRemote) contextt.lookup(jndiName);
 //   Company c1 = new Company("Orange","orangelogin","orangepass","orange@gmail.com","CEO_Orange","Tunis",(long)71322111,"0T1","Telecommunication",4,"good","orange.jpg");
//	Company c2 = new Company("Adidas","adidaslogin","adidaspass","adidas@gmail.com","CEO_adidas","France",(long)339585789,"0F1","Sport",5,"excellent","adidas.jpg");
//	Company c3 = new Company("Vermeg","vermeglogin","vermegpass","vermeg@gmail.com","CEO_vermeg","France",(long)339585789,"0F1","informatique",5,"excellent","vermeg.jpg");
   // Company c1 = new Company("Michelin","michelinlogin","michpass","michelin@gmail.com","CEO_Michelin","Allemagne",(long)4585269,"0D5","Production-Roue",4,"good","michelin.jpg");
	Company c2 = new Company("Berchka","berchkalogin","berchkapass","berchka@gmail.com","CEO_Berchka","Espagne",(long)339585789,"0E17","Vetement",5,"excellent","Zara.jpg");
	Company c3 = new Company("pullANDbear","pullANDbearlogin","pullANDbearpass","pullANDbear@gmail.com","CEO_pullANDbear","Tunisie",(long)71852963,"0T13","Vetement",5,"excellent","Astral.jpg");
	
	Company c8 = proxy.findBy((long)2) ;
	
	//System.out.println(proxy.ActivityRate(c));
//	proxy.add(c1);
    proxy.add(c2);
    proxy.add(c3);
    
	Contact c = proxy.findContact(proxy.findBy((long)7), proxy.findBy((long)3));
	System.out.println(c.toString());
	/*for (Object[] o : proxy.nbrcompanyperService(c2) ){
		 System.out.println(o[0]);
		 System.out.println(o[1]);
	 }*/
	
	//proxy.addContact(c ,proxy.findBy((long) 2), proxy.findBy((long)4));
	//System.out.println(proxy.getContactsByCompany((long) 2));
    
 
   /* Company companies = new Company();
    companies = proxy.findBy((long)20);
    System.out.println(companies);*/
       
	//System.out.println(InetAddress.getLocalHost().getHostAddress());
	
	//System.out.println("Ip: " + GetNetworkAddress.GetAddress("ip"));
	//System.out.println("Mac: " + GetNetworkAddress.GetAddress("mac"));
	
	//**************************************************************************************************
	
	/*InetAddress ip;
	try {
			
		ip = InetAddress.getLocalHost();
		System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}*/
	 // esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ContactService!tn.esprit.b1.esprit1718b1businessbuilder.services.ContactServiceRemote   
   /************************************************/
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
}
