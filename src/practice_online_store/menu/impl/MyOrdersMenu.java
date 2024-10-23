package practice_online_store.menu.impl;

import practice_online_store.configs.ApplicationContext;
import practice_online_store.enteties.Order;
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
		printMenuHeader();
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to see list of your orders");
			new MainMenu().start();
			return;
		} else {
			printUserOrdersToConsole();
		}
	}
	
	private void printUserOrdersToConsole() {
		Order[] loggedInUserOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
		
		if (loggedInUserOrders == null || loggedInUserOrders.length == 0) {
			System.out.println("Unfortunately, you don't have any orders yet. " + "Navigate back to main menu to place a new order");
		} else {
			for (Order order : loggedInUserOrders) {
				System.out.println(order);
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MY ORDERS *****");	
	}

}
