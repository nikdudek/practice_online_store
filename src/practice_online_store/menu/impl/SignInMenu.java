package practice_online_store.menu.impl;

import practice_online_store.configs.ApplicationContext;
import practice_online_store.menu.Menu;
import practice_online_store.services.UserManagementService;
import practice_online_store.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
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
