package practice_online_store.helpdesk.enteties.impl;

import practice_online_store.helpdesk.enteties.Priority;
import practice_online_store.helpdesk.enteties.RequestType;
import practice_online_store.helpdesk.enteties.SupportTicket;

public class DefaultSupportTicket implements SupportTicket {
	
	private static int counter;
	
	private RequestType requestType;
	private int sequentialNumber;
	
	{
		sequentialNumber = ++counter;
	}
	
	public DefaultSupportTicket() {
		// Default empty constructor
	}
	
	public DefaultSupportTicket(RequestType requestType) {
		this.requestType = requestType;
	}

	@Override
	public Priority getPriority() {
		if (requestType == null) {
			return null;
		}
		return this.requestType.getPriority();
	}

	@Override
	public int getSequentialNumber() {
		return this.sequentialNumber;
	}

	@Override
	public RequestType getRequestType() {
		return this.requestType;
	}

}
