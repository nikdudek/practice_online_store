package practice_online_store.menu.impl;

import java.util.Scanner;

import practice_online_store.configs.ApplicationContext;
import practice_online_store.enteties.User;
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
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please, enter your email: ");
		String userEmail = sc.next();
		
		System.out.print("Please, enter your password: ");
		String userPassword = sc.next();
		
		sc.close();
		
		User user = userManagementService.getUserByEmail(userEmail);
		if (user != null && user.getPassword().equals(userPassword)) {
			System.out.printf("Glad to see you back %s %s", user.getFirstName() + user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
		} else {
			System.out.println("Unfortunately, such login and password does not exist.");
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** Sign In *****");
	}

}
