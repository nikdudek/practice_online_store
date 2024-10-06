package practice_online_store.menu.impl;

import practice_online_store.configs.ApplicationContext;
import practice_online_store.menu.Menu;
import practice_online_store.services.OrderManagementService;
import practice_online_store.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>		
	}

}
