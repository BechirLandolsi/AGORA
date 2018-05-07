package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Comment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Forum;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Undercomment;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Word;

@Remote
public interface ForumServiceRemote {
	/////////////////Forum//////////////////////////
	public int ajouterForum(Forum forum);
	public Forum findForumById (int idforum);
    public List<Forum> getAllForum () ;
    public long nbrComment () ;
    public long nbrCommentForm (int idforum) ;
    public long nbrCompanyForum (int idforum) ;
    /////////////////Comment/////////////////////////
    public List<Comment> getallCommentByForum (int idforum) ;
    public int addComment (Comment c) ;
    public Comment findCommentById (int idComment) ;
    public void updateComment(Comment c);
    
    //////////////////UnderCOmment///////////////////
    public Undercomment findUnderCommentById (long idComment) ;
    public void updateUnderComment(Undercomment c);
    public long addUnderComment (Undercomment uc );
    public List<Undercomment> getAllUnderCommentbyComment(int idcomment);
    public List<Undercomment> getAllUnderCommentbyForm(int idForm);
    ///////////////////////IA///////////////////////////
    public List<Word> getAllWord () ; 
    public float NoteUnderComment(int idform) ;
    public float NoteComment(int idform) ;
    public float NoteProduct(Produit p, Forum f ) ;
    public List<Produit> getRecommandation(int idForum) ;
	List<Company> findCompanyBysynonyme(String r);
	public void ResponseComment(int idcomment) ;
	public  float currencyConvertion(String from,String to , float price) ;
}
