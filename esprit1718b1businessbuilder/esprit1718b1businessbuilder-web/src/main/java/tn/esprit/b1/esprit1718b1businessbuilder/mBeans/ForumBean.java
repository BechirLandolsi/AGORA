package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import tn.esprit.b1.esprit1718b1businessbuilder.entities.Comment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Forum;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Undercomment;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ForumService;

@ManagedBean
@SessionScoped
public class ForumBean {
	
	private Float quantity ;
	private Float res;
    private String comment ;
    private String undercomment ;
	private List<Forum> items;
	private Forum item;
	private Comment commentuc ;

  private Forum f = new Forum() ; 
	
	
	@EJB
	private ForumService forumservice;
	@ManagedProperty(value="#{identity}")
	private Identity identity ;
	
	public List<Forum> ForumList() {
		List<Forum> forums =	forumservice.getAllForum();	
		
		return forums  ;
	}
	public long nbrComment(int idforum) {
		return	forumservice.nbrCommentForm(idforum);	
	
	}
	public long totalComment() {
		return	forumservice.nbrComment();	
	
	}
	public long nbrCompanyForum(int idforum) {
		return	forumservice.nbrCompanyForum(idforum);	
	
	}
	public String  gotodetail(Forum forum) {
		this.f = forum ;
		return "/forum?faces-redirect=true";
	}
	public Forum getF() {
		return f;
	}
	public void setF(Forum f) {
		this.f = f;
	}
	public void submit() {
	    System.out.println(item);
	}
	public List<Comment> getCommentsByForum(int idforum){
		return forumservice.getallCommentByForum(idforum);	
	}
	public List<Undercomment> getunderCommentByComment(int idcomment) {
		return forumservice.getAllUnderCommentbyComment(idcomment);
	}
	public void doComment (){
		Comment c= new Comment() ;
		c.setComment(this.comment);
		Date d = new Date();
		c.setDatePost(d);
		if (!this.comment.equals("")){
		int x = forumservice.addComment(c);
		Comment c1= new Comment() ;
		c1 =forumservice.findCommentById(x);
		c1.setCompanyC((Company)identity.getUser());
		c1.setForumC(this.f);
		forumservice.updateComment(c1);
		}
		this.comment = null ;

	}
	public void doUnderComment (int c){
		
		Comment comment1=	forumservice.findCommentById(c);
		Undercomment c2= new Undercomment() ;
		c2.setComment(this.undercomment);
		c2.setDatePost(new Date());
		c2.setCommentUC(comment1);
		c2.setCompanyUC((Company)identity.getUser());
		if (!this.undercomment.equals("")){
			long x = forumservice.addUnderComment(c2);
		}
		
		this.undercomment = null ;

	}
	
	public float noteProduct (Produit p) {
		return forumservice.NoteProduct(p, this.f) ;
		
	}
	

	public String response (int idcomment){
		
		return null ;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUndercomment() {
		return undercomment;
	}
	public void setUndercomment(String undercomment) {
		this.undercomment = undercomment;
	}
	public Comment getCommentuc() {
		return commentuc;
	}
	public void setCommentuc(Comment commentuc) {
		this.commentuc = commentuc;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public List<Produit> getRecommandationP (){
		
		return forumservice.getRecommandation(this.f.getId());
	}
	
	
	public float CurrencyConverter () {
	 
		Company c = new Company() ;
		c= (Company)identity.getUser() ;
		System.out.println(f.getCompanyForum().getCurrency());
		System.out.println(quantity);
	res = forumservice.currencyConvertion(f.getCompanyForum().getCurrency(),c.getCurrency() , quantity) ;
	return res ;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public Float getRes() {
		return res;
	}
	public void setRes(Float res) {
		this.res = res;
	}
	
	
}
	