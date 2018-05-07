package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Date;
import java.util.List;


import javax.ejb.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contact;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.ContactPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.PartnershipPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
@LocalBean
public class CompanyService extends UserService implements CompanyServiceRemote{
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 
	
	@EJB
	OrderServiceRemote orderService ;
	
	
	@Override
	public List<Company> findAllCompany() {
		
		TypedQuery<Company> q =  em.createQuery("select c from Company c",Company.class) ;
		List<Company> companies = q.getResultList() ;
		return companies;
	
	}
	@Override
    public List<String> findAllCompanyNames() {
		
		TypedQuery<String> q =  em.createQuery("select c.name from Company c",String.class) ;
		List<String> companiesname = q.getResultList() ;
		return companiesname;
	
	}
		
	@Override
	public Company findAllCompanyByName(String name) {

		TypedQuery<Company> q =  em.createQuery("select c from Company c WHERE c.name = :name",Company.class) ;
		Company c = null  ;
		try{
		c =	q.setParameter("name", name).getSingleResult() ;
		}catch(NoResultException e){
			
		}
		
		return c ;
	}
	@Override
	public void AddCompanyReserche(Reserche r, Company c  ) {
		r.setCompanyR(c);
		em.persist(r);
	}
	@Override
	public Company findBy(Long id) {
		
		Company c =null ;
		c = em.createQuery("SELECT c FROM Company c WHERE c.id=:id",Company.class)
									.setParameter("id",id)
									.getSingleResult();
		
		return c ;
		
	}
	
	@Override
	public List<Company> findAllCompanyByService(String service){
		TypedQuery<Company> q =  em.createQuery("select c from Company c INNER JOIN c.services s where s.name LIKE :service",Company.class) ;
		List<Company> companies = q.setParameter("service", "%" + service+ "%").getResultList() ;
		return companies;
	}
	

	@Override
	public List <String> FindBySector(String sector)
	{
		TypedQuery<String> q = em.createQuery("select c.name from Company c WHERE c.sector=:sector", String.class ) ;
	
		return q.setParameter("sector", sector).getResultList();
	}
	
	@Override
	public List <String> getAllSectors()
	{
		TypedQuery<String> q = em.createQuery("select c.sector from Company c", String.class ) ;
		List <String> sectors = q.getResultList() ;
		return sectors;
		
	}
	
	
	@Override
	public void add(Company c) {
		em.merge(c);
		//em.persist(c);
		
	}

	@Override
	public List<Object []> bestCompany() {
		 Query  q =  em.createQuery("select count(p) , p.supplier from Produit p GROUP BY p.supplier ") ;
		 List<Object []> company = q.getResultList() ;
			return company;
		
		
	}
	
	@Override
	public long nbProjectByCompany(Company c) {
		TypedQuery<Long> q = em.createQuery("select count(p) from Project p WHERE p.ProjectOwner =:id", Long.class ) ;
		//List <String> names = q.getResultList() ;
		//return names;
		return q.setParameter("id", c).getSingleResult();
	}



	@Override
   public List<String> FindBySectorButCompany(Long companyId, String sector) {
		
		TypedQuery<String> k = em.createQuery("select c.name from Company c where c.sector=:sector", String.class ) ;
		 k.setParameter("sector", sector).getResultList();
		
		 return k.setParameter("companyId", companyId).getResultList();
	}
	
	
	@Override
	public List<Company> findCompanyBySector2(String sector) {

		TypedQuery<Company> q = em.createQuery("select c from Company c WHERE c.sector=:sector", Company.class ) ;
	
		return q.setParameter("sector", sector).getResultList();
	}
	
	
	
	
	
	@Override
	public void addContact(Contact cont , Company c1, Company c2) {
		
		ContactPK ContactPK = new ContactPK(c1.getId(), c2.getId()) ;
		cont.setContactPK(ContactPK);
		
		em.persist(cont);
		
	}
	@Override
	public List<Company> getContactsByCompany(Long CompanyId) {
		TypedQuery <Company> k = em.createQuery("select c.CompanyContact from Contact c where c.Company.id="+CompanyId,Company.class);

		List <Company> list = k.getResultList();
		
		return list;
	}
	
	@Override
	public void incrementnbrFlowwersFollowings (Company c , Company c2){
		c.setNbrfolowers(c.getNbrfolowers()+1);
		c2.setNbrfolowings(c2.getNbrfolowings()+1);
	//	c.setVisite(c.getVisite()+1);
		em.merge(c);
		em.merge(c2);
	}
	
	@Override
	public void incrementVisiteProfile (Company c) {
	System.out.println("dkhalna");
	System.out.println("l9dim"+c.getVisite());
	c.setVisite(c.getVisite()+1);
	System.out.println("jdid"+c.getVisite());
//	c.setVisteprofile(c.getVisteprofile()+1);
	em.merge(c); em.flush();
	/*String format = "dd/MM/yy H:mm:ss";
	java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
	java.util.Date da = new java.util.Date(); 
	c.setDateVisite(da);*/
		
	//em.persist(c);
	}
	
	@Override
	public List<Object []> nbrcompanyperService(Company c ) {
		
		Query q =  em.createQuery("select count(p),p.Company.sector from Contact p where p.Company=:var group by p.Company.sector ");
		  
		List<Object[]> companies = q.setParameter("var", c)
									.getResultList() ;
		return companies; 
		
	}
	@Override
	public void countnbrs(Company c) {
		
		c.setNbrorders(orderService.findAllOrder(c).size());
		c.setNbrprojects((int) this.nbProjectByCompany(c) );
		em.merge(c);
		
	}
	
	@Override
	public void ActivityRate(Company c) {
		
		this.findBy(c.getId());
		float socialActivity = ((c.getNbrfolowers()+c.getNbrfolowings()+c.getVisite())/3)*100;
		float proActivity =((c.getNbrprojects()+c.getNbrorders())/3)*100;
		float activity = (float) ((0.4 *socialActivity) + (0.6*proActivity)) ;
		c.setActivity(activity);
	    em.merge(c);
	}
	
	
	
	
	
	
}
