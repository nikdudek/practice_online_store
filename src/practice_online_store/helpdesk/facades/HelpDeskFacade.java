package practice_online_store.helpdesk.facades;

import practice_online_store.helpdesk.enteties.SupportTicket;

public interface HelpDeskFacade {

	void addNewSupportTicket(SupportTicket supportTicket);
	
		SupportTicket getNextSupportTicket();

		/**
		 * @return amount of tickets that are not processed
		 */
		int getNumberOfTickets();
}
