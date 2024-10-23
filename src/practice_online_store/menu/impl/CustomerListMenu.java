package practice_online_store.menu.impl;

import practice_online_store.configs.ApplicationContext;
import practice_online_store.enteties.User;
import practice_online_store.menu.Menu;
import practice_online_store.services.UserManagementService;
import practice_online_store.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		User[] users = userManagementService.getUsers();
		
		if (users.length == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** USERS *****");
	}

}
