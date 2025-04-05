package practice_online_store.storage.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import practice_online_store.enteties.User;
import practice_online_store.storage.UserStoringService;

public class DefaultUserStoringService implements UserStoringService {
	
	private static DefaultUserStoringService instance;
	private final File file;
	
	static {
		instance = null;
	}
	
	private DefaultUserStoringService() {
	}
	
	public static DefaultUserStoringService getInstance() {
		if(instance == null) {
			instance = new DefaultUserStoringService();
		}
		return instance;
	}
	
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
		
		try {
			Files.write(Paths.get("StorageDir", "users.txt"), textToWrite.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch(Exception e) {
			e.printStackTrace();
		};
		//TODO user private static void writeNio() from lesson 129. as reference
	}

	@Override
	public List<User> loadUsers() {
		// TODO load all from a file, add as new lines to the list
		return null;
	}

}
