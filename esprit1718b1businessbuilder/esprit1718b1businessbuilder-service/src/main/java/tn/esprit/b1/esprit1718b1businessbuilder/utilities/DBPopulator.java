package tn.esprit.b1.esprit1718b1businessbuilder.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Admin;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceLocal;

@Singleton
@Startup
public class DBPopulator {
	@EJB
	private UserServiceLocal userServiceLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() throws ParseException {
		//User user = new User("user", "u", "u", "user@bitbox.tn");
        
		
		
		//*******************************************************************
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dat =dateFormat.parse("31/04/2018");
		Date dat1 =dateFormat.parse("05/05/2018");
		Date dat2 =dateFormat.parse("06/06/2018");
		Date dat3 =dateFormat.parse("07/07/2018");
		Date dat4 =dateFormat.parse("31/11/2018");
		Date dat5 =dateFormat.parse("31/10/2018");
		Date dat6 =dateFormat.parse("15/12/2018");
		Date dat7 =dateFormat.parse("18/12/2018");
		Date dat8 =dateFormat.parse("06/08/2018");
		
		Event e = new Event("Vermeg Opening", "Germany , Berlin", "Software","Company Opening",true,true,dat);
		Event e1 = new Event("Orange milestones", "Tunisia ,Tunis", "Telecommunications","ompany milestones",true,true,dat1);
		Event e2 = new Event("Delice Event", "Germany , frankfurt", "Food","Product launch",false,true,dat2);
		Event e3 = new Event("Wevioo Fest", "Libya , tripoli", "Software","Appreciation Event",true,true,dat3);
		Event e4 = new Event("Said chocolate tasting", "France , Paris", "Food","Product launch",true,false,dat4);
		Event e5 = new Event("Vitalait Product launch", "china , pekin", "Food","Product launch",true,true,dat5);
		Event e6 = new Event("Channel New Perfum", "Korea , Seoul", "cosmetics","Product launch",false,false,dat6);
		Event e7 = new Event("Dolce & Gabana Opening", "Tunisia , tataouine", "cosmetics","Trade Show",false,true,dat7);
		Event e8 = new Event("Wolkswagen Exhibition", "Tunisia , Nabeul", "cars","Exhibition",true,false,dat8);*/
		//*******************************************************************
	//userServiceLocal.update(user);
		/***** Add Admin *****/
		//User u = new Admin("Admin","Admin","adminpass","admin@agora.com"); 
		//User u = new Company("company1","companylog","pass","comp@gmail.com","ceo","adress",4,"aa","vetement",3,null,null);
	//userServiceLocal.save(u);
		/******************************/
				
	}
}
