package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.management.relation.Role;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.*;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProject;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.CommentProjectPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Translation;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CommentProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TranslationService;


@ManagedBean
@SessionScoped

//@ViewScoped
//@RequestScoped

@ServerEndpoint(value = "/notification")



public class ProjectBean {
	

	private List<Long> idPartnership;
	private String durationpart;
	private String nameProject;
	private String natureProject;	
	private String natureProduct;
	private Long idProject;
	
	private Date dateComment;
	
	Partnership partnershipclass = new Partnership();

	private String mot;
	

	private List <Project> listproject;
	private List <Project> listproject2;
	private List <Partnership> listpartners;
	private List <Partnership> listpartnerships;
	private long k;
	
	private List <CommentProject> listcomment;

	
	private PieChartModel pieModel1;
	private BarChartModel barChartModel;
	
	
	
	static ArrayList<Session> sessions = new ArrayList<>();
	
/************************************************************************************************************/	
	
	private List <CommentProject> listcomments;
	private String commentBody;

	
/***********************************************************************************************************/	
		
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity ; 
	
	@EJB
	ProjectService projectservice;
	@EJB
	PartnershipService partnershipservice;
	@EJB
	CommentProjectService commentprojectservice;
	@EJB
	TranslationService translationservice;


	
/********************************************************************************************************/	
	
	
	public String hez (Long idproject)
	{ 
		
	String navigateTo=null;
	navigateTo="/partnership?faces-redirect=true";
	
	this.idProject=idproject;
	

	return navigateTo;
	
	}
	
	
	
	public Project jib()
	{
		Project e = new Project();
		e= projectservice.findProjectById(this.idProject).get(0);
		//partnershipclass=e;
		return e;
		
	}
	
	public double calculAvancemProject(Project p)
	{
		return projectservice.AvancementProject(p);
		
	}
	
	
	  public PieChartModel createPieModel1(Company c) {
		  
	        pieModel1 = new PieChartModel();
	        
	        Long l1=projectservice.CountStableProjects(c);
	        Long l2=projectservice.CountUnstableProjects(c);
	        
	        pieModel1.set("Stable Projects", l1);
	        pieModel1.set("UnStable Projects", l2);
	      
	        pieModel1.setTitle("Simple Pie");
	        pieModel1.setLegendPosition("w");
	        
	        return pieModel1;
	    }
	
	
public BarChartModel createBarModel(Company c) {
		  
		  barChartModel = new BarChartModel();
	    
		  barChartModel.setTitle("Bar Chart");
		  barChartModel.setLegendPosition("ne");
	         
	        Axis xAxis = barChartModel.getAxis(AxisType.X);
	        xAxis.setLabel("Projects");
	         
	        Axis yAxis = barChartModel.getAxis(AxisType.Y);
	        yAxis.setLabel("Progress rate");
	        yAxis.setMin(0);
	        yAxis.setMax(100);
		  
	        
	        
	        List <String> l1 = new ArrayList<>();
	        List <Number> l2 = new ArrayList<>();
	        
	        l1=projectservice.getProjectsNameByCompanyjsf(c.getId());
	        l2=projectservice.AvancementDesProjetsByCompanyjsf(c.getId());

	       
	        
	        for(int i=0;i<l1.size();i++)
	        {
	        	ChartSeries projects = new ChartSeries();
	        	
	        	 projects.setLabel(l1.get(i));
	        	projects.set(l1.get(i),l2.get(i));
	        	 barChartModel.addSeries(projects);
	        	
	        }
	       
	         
	        return barChartModel;
	    }

	
		public int mathround(double d)
		{
			int a = (int) Math.round(d);
			return a;
			
		}

	
		
	public String ListProjectByRecherche(String mot)
	{	
		
		this.listproject= projectservice.searchForProject(mot,(Company)this.identity.getUser());
			
		
		return "/projectlist?faces-redirect=true"; 
		
	}
	
	public List<Project> ListProject()
	
	{	
		if (this.mot==null)
			
		 {
			this.listproject = projectservice.getProjectsByCompany(identity.getUser().getId());
			return this.listproject;
		
		 }
		
		this.mot=null;
		return this.listproject;
			
		
	}
/***********************************************************************************************************/	
	
public List<CommentProject> ListComment()
	
	{	
		
			Project pr= new Project();
			pr=projectservice.findProjectById(this.idProject).get(0);
			this.listcomment = commentprojectservice.AfficherCommentByProject(pr);
			return this.listcomment;
		
		
			
		
	}

public String ListCommentTranslated(Date date)
{	
	System.out.println("/////////////"+date);

	List<String> body = translationservice.translateComment(date);
	
	System.out.println("///////////////////////"+body);
	
	StringBuilder sb = new StringBuilder();
	 for (String s : body)
     {
         sb.append(s);
         sb.append(" ");
     }
	 
	 CommentProject cp = new CommentProject();
	 cp.setCommentBody(sb.toString());
	 this.listcomment = commentprojectservice.AfficherCommentByProject(jib());
	 this.listcomment.add(cp);
	return "/partnership?faces-redirect=true"; 
	
}
	
/***********************************************************************************************************/	
	
	public List<Partnership> ListPartners(Project p)
	{
		
		return listpartners = partnershipservice.PartnershipByProject(p);
	}
	
	
	public List<Partnership> ListPartnership()
	{
		
		return listpartnerships = partnershipservice.PartnershipNonConfirm(identity.getUser().getId());
	}

	public long countPartnershipNonConfirm()
	{
		
		return k = partnershipservice.countPartnershipNonConfirm(identity.getUser().getId());

		
	}
	

	
/********************************************************************************************************/	
	
	public List<CommentProject> getComments(Project p)
	{
		return listcomments= commentprojectservice.AfficherCommentByProject(p);
		
	}
	
	public Date convert(Date date)
	{
		return commentprojectservice.ConvertDate(date);
	}
	
	
	
	public String AddComment(Project p, Company c)
	{
		String body = this.commentBody;
		this.commentBody = null;
		CommentProject comment= new CommentProject();
		CommentProjectPK pk = new CommentProjectPK();
		
		Date date = new Date();
		
		pk.setCommentDate(date);
		pk.setCompanyId(c.getId());
		pk.setProjectId(p.getId());
		
		
		
		commentprojectservice.addCommentOnProject(body, pk,comment);
		return "/partnership?faces-redirect=true";
		
	}
	
	public int CalculCommentByProject(Project p)
	{
		int a;
		return a=this.getComments(p).size();
	}
	
	
	public String getComment(Date datecomment)
	{ 
		
	String navigateTo=null;
	navigateTo="/partnership?faces-redirect=true";
	
	this.dateComment=datecomment;
	

	return navigateTo;
	
	}
	
	
	
	
	
	
/************************************************************************************************************/
	
	@OnMessage
	  public void messageReceiver(String message) {
	    System.out.println("Received message:" + message);
	  }
	

	@OnOpen
	  public void onOpen(Session session) {
	    System.out.println("onOpen: " + session.getId());
	    sessions.add(session);
	    System.out.println("onOpen: Notification list size: " + sessions.size());
	  }
	
	 public void countPerson() {
		 	Company c =new Company();
		 	//c.setName("vermeg");
		   
		  long i= projectservice.CountStableProjects(c);
		  }
	
/************************************************************************************************************/


	public List<Long> getIdPartnership() {
		return idPartnership;
	}

	public void setIdPartnership(List<Long> idPartnership) {
		this.idPartnership = idPartnership;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public String getNatureProject() {
		return natureProject;
	}

	public void setNatureProject(String natureProject) {
		this.natureProject = natureProject;
	}

	public String getNatureProduct() {
		return natureProduct;
	}

	public void setNatureProduct(String natureProduct) {
		this.natureProduct = natureProduct;
	}

	public List<Project> getListproject() {
		return listproject;
	}


	public void setListproject(List<Project> listproject) {
		this.listproject = listproject;
	}


	public static ArrayList<Session> getSessions() {
		return sessions;
	}


	public static void setSessions(ArrayList<Session> sessions) {
		ProjectBean.sessions = sessions;
	}

	public List<Partnership> getListpartners() {
		return listpartners;
	}

	public void setListpartners(List<Partnership> listpartners) {
		this.listpartners = listpartners;
	}

	public List<Partnership> getListpartnerships() {
		return listpartnerships;
	}

	public void setListpartnerships(List<Partnership> listpartnerships) {
		this.listpartnerships = listpartnerships;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	

	public long getK() {
		return k;
	}

	public void setK(long k) {
		this.k = k;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public String getDurationpart() {
		return durationpart;
	}

	public void setDurationpart(String durationpart) {
		this.durationpart = durationpart;
	}
	
	

	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}
	
	

	public Partnership getPartnershipclass() {
		return partnershipclass;
	}

	public void setPartnershipclass(Partnership partnershipclass) {
		this.partnershipclass = partnershipclass;
	}

	public List<Project> getListproject2() {
		return listproject2;
	}

	public void setListproject2(List<Project> listproject2) {
		this.listproject2 = listproject2;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}
	
	
	

	public BarChartModel getBarChartModel() {
		return barChartModel;
	}

	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}

	
	
	public List<CommentProject> getListcomments() {
		return listcomments;
	}



	public void setListcomments(List<CommentProject> listcomments) {
		this.listcomments = listcomments;
	}



	public String getCommentBody() {
		return commentBody;
	}



	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	

	public Date getDateComment() {
		return dateComment;
	}



	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}



	@Override
	public String toString() {
		return "ProjectBean [idPartnership=" + idPartnership + ", durationpart=" + durationpart + "]";
	}
	
	
	
	
	

}
