package practice_online_store.helpdesk.facades.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import practice_online_store.helpdesk.enteties.SupportTicket;
import practice_online_store.helpdesk.facades.HelpDeskFacade;
import practice_online_store.helpdesk.utils.CustomSupportTicketsComparator;

public class DefaultHelpDescFacade implements HelpDeskFacade {
	
	private Queue<SupportTicket> tickets;
	
	{
		tickets = new PriorityQueue<>(new CustomSupportTicketsComparator());
	}

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		tickets.offer(supportTicket);
	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return tickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return tickets.size();
	}

}
