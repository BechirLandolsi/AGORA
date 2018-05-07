package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Invitation;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.InvitationPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;




@Stateless
public class InvitationService  implements InvitationServiceRemote {
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 
	
	public void InviteCompanyToAnEvent(long idCompany , long idEvent) {
		  Invitation invitation = new Invitation();
		  InvitationPK invitationpk = new InvitationPK();
		  invitationpk.setIdEvent(idEvent);
		  invitationpk.setIdCompanyGuest(idCompany);
		  invitation.setInvitationPK(invitationpk);
		  java.util.Date da = new java.util.Date();
		  invitation.setInvitationDate(da);
		  invitation.setParticipation_price(0);
		  em.persist(invitation);
		  //event.getInvitation().add(invitation);
		  //guest.getInvitation().add(invitation);
		  
	}

	@Override
	public long countnumberinvitation(Event e) {
		Query q =  em.createQuery("select count(e)  from Invitation e where e.Event=:id") ;
		q.setParameter("id",e);
		long nombre = (long) q.getSingleResult();
		return nombre;
	}


	
	@Override
	public Invitation replyToInvitation(Company c , Event e,boolean guest_Response) {
		Invitation invit = new Invitation();
		TypedQuery<Invitation> query = em.createQuery("select i from Invitation i where i.Event=:event and i.guest=:company",Invitation.class);
		query.setParameter("company", c);
		query.setParameter("event",e);
		invit=query.getSingleResult();
		Query q =  em.createQuery("update Invitation i set i.guest_Response=:rep where i=:invitation") ;
		q.setParameter("rep",true);
		q.setParameter("invitation", invit);
		q.executeUpdate();
		return invit;
		
	}



	@Override
	public List<Invitation> DisplayInvitationByCompany(Company c) {
		 List<Invitation> invitation_list;
		 TypedQuery <Invitation> q = em.createQuery("select i from Invitation i where i.guest=:param",Invitation.class);
		 q.setParameter("param",c);
		 invitation_list = q.getResultList();
		return invitation_list;
	}

	
	@Override
	public long countnumberguest(Event e) {
		Query q =  em.createQuery("select count(e)  from Invitation e where e.Event=:id AND e.guest_Response="+true) ;
		q.setParameter("id",e);
		long nombre = (long) q.getSingleResult();
		return nombre;
	}

}
