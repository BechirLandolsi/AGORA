package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javafx.scene.chart.XYChart;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Provision;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProvisionService;

@ManagedBean
@ViewScoped
public class ProvisionBean {
	
	private List<Provision> provisionD  ; 
	private List<Provision> provisionP  ; 
	
	private List<String> lineX = new ArrayList<>(); 
	private List<Integer> lineY = new ArrayList<>();
	private Map<String, Integer> lineData = new HashMap<String, Integer>() ;  
	
	//private List<Object[]> lineData ; 
	
	@EJB
	private ProvisionService provisionService ;
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity ; 
	
	/*
	@PostConstruct
    public void init() {
		createLineData();
    }*/
	
	
	public Map<String, Integer> getLineData(){
		List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
		System.out.println(list.toString());
		for(Object[] o : list){
       	 	long qt = (long)o[0] ;
       	 
       	 	Produit produit = (Produit)o[1] ;
       	 	Order order = (Order)o[2] ;
       	 	Date date = order.getOrderDate();
	    	double ammount = qt *( produit.getPrice() - produit.getCout() );
	    	
	    	lineData.put(date.toString(), (int)ammount);
	    	
		}
		return lineData;
		
		
	}
	
	public String redirectSales(){
		return "/SalesDashboard?faces-redirect=true";
	}
	
	
	
	public void setLineData(Map<String, Integer> lineData) {
		this.lineData = lineData;
	}



	public Integer calculqTBD(){
		int q = provisionService.provisionTBD((Company)identity.getUser());
		
		return q;
	}

	public Integer calculQuantityTBP(){
		int q = provisionService.provisionTBP((Company)identity.getUser());
		
		return q;
	}
	
	public Float getQuantityTBI(){
		float q = provisionService.provisionTBI((Company)identity.getUser());
		
		return q;
	}
	
	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	public String getCurrent(){
		String PATTERN="yyyy-MM-dd";
		    SimpleDateFormat dateFormat=new SimpleDateFormat();
		    dateFormat.applyPattern(PATTERN);
		    String today =dateFormat.format(Calendar.getInstance().getTime());
		return today; 
	}
	
	public void makeDelivered(Provision p){
		System.out.println(p.toString());
		provisionService.updateDelivery(p.getId());
	}
	
	public void makePacked(Provision p){
		System.out.println(p.toString());
		provisionService.updatePackaging(p.getId());
	}
	
	
	public Integer getQuantityTr(){
		return provisionService.quantityToRecieve((Company)identity.getUser()); 
	}
	
	public Integer getQuantityIh(){
		return provisionService.quantityInhand((Company)identity.getUser()); 
	}

	public List<Provision> getProvisionD() {
		return provisionService.getProvisionTBD((Company)identity.getUser());
	}

	public void setProvisionD(List<Provision> provisionD) {
		this.provisionD = provisionD;
	}

	public List<Provision> getProvisionP() {
		return provisionService.getProvisionTBP((Company)identity.getUser());
	}

	public void setProvisionP(List<Provision> provisionP) {
		this.provisionP = provisionP;
	}


	public List<String> getLineX() {
		List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
		System.out.println(list.toString());
		for(Object[] o : list){
       	 	long qt = (long)o[0] ;
       	 
       	 	Produit produit = (Produit)o[1] ;
       	 	Order order = (Order)o[2] ;
       	 	Date date = order.getOrderDate();
	    	double ammount = qt *( produit.getPrice() - produit.getCout() );
	    	
	    	System.out.println(date);
	    	System.out.println(ammount);
	    	this.lineX.add(date.toString()) ; 
		}
	    	
		return lineX ;
	}


	public void setLineX(List<String> lineX) {
		this.lineX = lineX;
	}


	public List<Integer> getLineY() {
		List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
		System.out.println(list.toString());
		for(Object[] o : list){
       	 	long qt = (long)o[0] ;
       	 
       	 	Produit produit = (Produit)o[1] ;
       	 	Order order = (Order)o[2] ;
       	 	Date date = order.getOrderDate();
	    	double ammount = qt *( produit.getPrice() - produit.getCout() );
	    	
	    	System.out.println(date);
	    	System.out.println(ammount);
	    	 
	    	this.lineY.add((int)ammount);
		}
		return lineY;
	}


	public void setLineY(List<Integer> lineY) {
		this.lineY = lineY;
	}



	
	
	

}
