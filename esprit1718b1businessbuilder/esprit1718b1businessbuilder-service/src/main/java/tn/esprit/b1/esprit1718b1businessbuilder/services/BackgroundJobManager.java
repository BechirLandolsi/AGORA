package tn.esprit.b1.esprit1718b1businessbuilder.services;


import javax.ejb.EJB;

import javax.ejb.Singleton;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;





@Singleton
public class BackgroundJobManager implements ServletContextListener {
	
	@EJB
	ProvisionService ps ; 
	
	
	
	    
	//	private Thread executor ; 

	    
		@Override
		public void contextInitialized(ServletContextEvent sce) {
		/*	while(true) {
			
				executor = new Thread(new Runnable() {

				@Override
				public void run() {
				ps.verifyStock();
				}
				});
			executor.start();
			try {
				executor.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}*/
		}
		
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			
			/* if(executor != null)
				  executor.interrupt();
			*/
		}


}
		
