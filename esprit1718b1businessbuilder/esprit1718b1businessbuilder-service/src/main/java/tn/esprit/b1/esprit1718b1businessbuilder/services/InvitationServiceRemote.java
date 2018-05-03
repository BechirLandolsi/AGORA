package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Invitation;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;;
@Remote
public interface InvitationServiceRemote {
	public void InviteCompanyToAnEvent(long idCompnay , long idEvent);
	public long countnumberinvitation(Event e);
    public Invitation replyToInvitation(Company c , Event e,boolean guest_Response);
    public List<Invitation> DisplayInvitationByCompany(Company c);
    public long countnumberguest(Event e);
}
