package practice_online_store.storage.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import practice_online_store.enteties.User;
import practice_online_store.storage.UserStoringService;

public class DefaultUserStoringService implements UserStoringService {
	
	private final File file;
	
	{
		file = new File("StorageDir" + File.separator + "users.csv");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void saveUser(User user) {
		String textToWrite = 
				user.getId() + File.pathSeparator +
				user.getFirstName() + File.pathSeparator + 
				user.getLastName() + File.pathSeparator + 
				user.getEmail() + File.pathSeparator + 
				user.getPassword();
		//TODO user private static void writeNio() from lesson 129. as reference
	}

	@Override
	public List<User> loadUsers() {
		// TODO load all from a file, add as new lines to the list
		return null;
	}

}
