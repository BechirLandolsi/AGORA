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
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;

public class MariemMain {
	public static void main(String[] args) throws NamingException, SocketException {
	
	String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
	Context context = new InitialContext();
	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
	
	User us = new User("name3", "login", "password", "email");
	User us2=new User("name4", "login", "password", "email");
	//proxyCategory.save(us);
	//us2=proxyCategory.update(us);
	
	/******************************/
  /*  String jndiName ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
    Context contextt = new InitialContext();
    CompanyServiceRemote proxy = (CompanyServiceRemote) contextt.lookup(jndiName);
    
    Company companies = new Company();
    companies = proxy.findBy((long)20);
    System.out.println(companies);*/
       
	//System.out.println(InetAddress.getLocalHost().getHostAddress());
	
	//System.out.println("Ip: " + GetNetworkAddress.GetAddress("ip"));
	//System.out.println("Mac: " + GetNetworkAddress.GetAddress("mac"));
	
	//**************************************************************************************************
	
	InetAddress ip;
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
			
	}
	    
   }
	
	
	
	
	
	
	
	
	
	
}
