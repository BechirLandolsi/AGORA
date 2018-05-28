package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.json.JSONObject;

import com.github.kevinsawicki.http.HttpRequest;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Comment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Forum;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Undercomment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Word;

@Stateless
@LocalBean
public class ForumService implements ForumServiceRemote{
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public int ajouterForum(Forum forum) {
	em.persist(forum);
		return forum.getId();
	}

	@Override
	public List<Forum> getAllForum() {
		TypedQuery<Forum> q = em.createQuery("select f from Forum f " , Forum.class ) ;
		List <Forum> forums = q.getResultList() ;
		return forums ;
	}

	@Override
	public long nbrCommentForm(int idforum) {
		Forum f = em.find(Forum.class, idforum) ;
		Query q = em.createQuery("select Count(c)  from Comment c  WHERE c.forumC=:f ") ;
		q.setParameter("f", f);
	    
		return (long) q.getSingleResult() ;
	
	}

	@Override
	public long nbrCompanyForum(int idforum) {
		Forum f = em.find(Forum.class, idforum) ;
		Query q = em.createQuery("select Count(DISTINCT c.companyC)  from Comment c  WHERE c.forumC=:f ") ;
		q.setParameter("f", f);
		return (long) q.getSingleResult();
	}

	@Override
	public long nbrComment() {
		Query q = em.createQuery("select Count(c)  from Comment c") ;
		return (long) q.getSingleResult() ;
	}

	@Override
	public List<Comment> getallCommentByForum(int idforum) {
		Forum f = em.find(Forum.class, idforum) ;
		TypedQuery<Comment> q = em.createQuery("select c from Comment c WHERE c.forumC=:f" , Comment.class ) ;
		q.setParameter("f", f);
		List <Comment> comments = q.getResultList() ;
		return comments;
	}

	@Override
	public List<Undercomment> getAllUnderCommentbyComment(int idcomment) {
		Comment c = em.find(Comment.class, idcomment) ;
		TypedQuery<Undercomment> q = em.createQuery("select uc from Undercomment uc WHERE uc.CommentUC=:c" , Undercomment.class ) ;
		q.setParameter("c", c);
		List <Undercomment> UnderComments = q.getResultList() ;
		
		return UnderComments;
	}

	@Override
	public int addComment(Comment c ) {
		
		
		em.persist(c);
		
		ResponseComment(c.getId()) ;

		return c.getId() ;
	}

	@Override
	public long addUnderComment(Undercomment uc) {
	
		em.persist(uc);
		return uc.getId() ;
	}

	@Override
	public Comment findCommentById(int idComment) {
		Comment c = em.find(Comment.class, idComment) ;
		return c;
	}

	@Override
	public void updateComment(Comment c) {
		em.merge(c) ;
		
	}

	@Override
	public Undercomment findUnderCommentById(long idComment) {
		Undercomment c = em.find(Undercomment.class, idComment) ;
		return c;
	}

	@Override
	public void updateUnderComment(Undercomment c) {
		em.merge(c) ;
		
	}

	@Override
	public List<Undercomment> getAllUnderCommentbyForm(int idforum) {
		Forum f = em.find(Forum.class, idforum) ;
        List<Comment> comments = getallCommentByForum(idforum);
        List<Undercomment> undercomments = new ArrayList<>() ;
        for (Comment c : comments){
        	undercomments.addAll(getAllUnderCommentbyComment(c.getId())) ;
        }
		return undercomments;
	}

	@Override
	public List<Word> getAllWord() {
		TypedQuery<Word> q = em.createQuery("select w from Word w" , Word.class ) ;
		List <Word> words = q.getResultList() ;
		return words;
	}

	@Override
	public float NoteUnderComment(int idform) {
		Forum f = em.find(Forum.class, idform) ;
		List<Undercomment> ucomments =   getAllUnderCommentbyForm(idform);
		List<Word> words =   getAllWord();
		System.out.println(words.toString());
		   int x = 0 ;
		   int nbr = 0 ;
		   for (Undercomment ucc : ucomments ) {
			   Pattern p = Pattern.compile("[a-zA-Z]+");
		         
		        Matcher m1 = p.matcher(ucc.getComment());
		        while (m1.find()) {
		        	 for (Word w : words ) {
		        	if (m1.group().equals(w.getWord())){
		        	   nbr ++ ;
		        		x = x + w.getPoint() ;
		        	   System.out.println(x);
		        	}
		        }
		   }
		
	}
		 
				  if (x == 0){
					  return 0 ;
				  } else{
					  return (x/nbr);
				  }
			  
	}

	@Override
	public float NoteComment(int idform) {
		//Forum f = em.find(Forum.class, idform) ;

		List<Comment> comments =   getallCommentByForum(idform);
		List<Word> words =   getAllWord();
		//System.out.println(words.toString());
		   int x = 0 ;
		   int nbr = 0 ;
		   for (Comment c : comments ) {
			   Pattern p = Pattern.compile("[a-zA-Z]+");
		        Matcher m1 = p.matcher(c.getComment());
		        while (m1.find()) {
		        	 for (Word w : words ) {
		        	if (m1.group().equals(w.getWord())){
		        		nbr ++ ;
		        	   x = x + w.getPoint() ;
		        	   System.out.println(x);
		        	}
		        }
		   }
		
	} 
		   if (x==0){
			   return 0 ;
		   }
			   return (x/nbr);
	}

	@Override
	public float NoteProduct(Produit p,Forum f) {
		
		float x1 =NoteUnderComment(f.getId()) ;
		float x2 =NoteComment(f.getId()) ;
		float res = 0 ;
		res =(x1+x2)/2 ;
			Produit p1 = em.find(Produit.class, f.getProductF().getId());
		  p1.setRate(res);
		   em.merge(p1) ;
			   return res;                                                           
                                                                          
	}                                                                     
                                                                          
	@Override                                                             
	public Forum findForumById(int idforum) {                             
		Forum f = em.find(Forum.class, idforum)    ;                       
                                                                          
		return f;                                                         
	}

	@Override
	public List<Company> findCompanyBysynonyme(String r) {
		 TypedQuery<Company> q =  em.createQuery("select c from Company c INNER JOIN c.services s where s.name IN (select s.service from Synonyme s where   s.synonyme1 LIKE :service OR s.synonyme2 LIKE :service OR s.synonyme3 LIKE :service OR s.synonyme4 LIKE :service OR s.synonyme5 LIKE :service)",Company.class) ;
		 
		 List<Company> companies  =	q.setParameter("service",  "%" + r + "%" ).getResultList();
		return companies;
	}

	@Override
	public List<Produit> getRecommandation(int idForum) {
		Forum f = em.find(Forum.class, idForum);   
		 Pattern p = Pattern.compile("[a-zA-Z]+");
		 Matcher m1 = p.matcher(f.getDescription());
		 List<Company> companies = new ArrayList<>();
		 List<Produit> produits = new ArrayList<>();
	        while (m1.find()) {
	        
	        	System.out.println(m1.group().length());
	        	if(m1.group().length()>4){
	        	 	
	        		companies.addAll(findCompanyBysynonyme(m1.group()));
	        	}
	        	
	        }
	        
	        for (Company c : companies ){
	        	produits.addAll(c.getProduits()) ;
	        }
			return produits;
    
	}
	@Override
	public void ResponseComment(int idcomment) {
		Comment comment = em.find(Comment.class, idcomment);   
		
		Pattern p = Pattern.compile("[a-zA-Z]+");
		
			
			 Matcher m1 = p.matcher(comment.getComment());
			 while (m1.find()) {
				 
				 if (m1.group().equals("products")){
					 Undercomment uc = new Undercomment("check out other product in Agora business throught this link"
					 		+ "                                                                                                    "
					 		+ "http://localhost:18080/esprit1718b1businessbuilder-web/forum.jsf",new Date(),comment);
					long x = addUnderComment(uc);
					 Undercomment uccc = em.find(Undercomment.class, x);   
					 Company f = em.find(Company.class, (long)7);   
					 uccc.setCompanyUC(f);
					 em.merge(uccc) ;
				   
				 }
			 }
		}
	
	
	@Override
	public  float currencyConvertion(String from,String to , float price)
	{
		String response = HttpRequest
				.get("https://v3.exchangerate-api.com/bulk/4f46365f63635a74262a885c/"+from)
				.accept("application/json").body();
		JSONObject jsonObject = new JSONObject(response);
		JSONObject status = jsonObject.getJSONObject("rates");
		Double eur = status.getDouble(to);
		return (float) (eur * price) ;
	}
	}
	
	
	
	
	

                                                                      
                                                                          

