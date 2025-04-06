package practice_online_store.storage.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import practice_online_store.enteties.User;
import practice_online_store.enteties.impl.DefaultUser;
import practice_online_store.storage.UserStoringService;

public class DefaultUserStoringService implements UserStoringService {
	
	private static final String 	USER_STORAGE_FILENAME = "names.csv";
	private static final String 	ROOT_RESOURCES_FOLDER = "practice_online_store";
	private static final String		USER_STORAGE_RESOURCE_FOLDER = "resources";
	private static final int 		USER_ID_INDEX = 0;
	private static final int 		USER_FIRSTNAME_INDEX = 1;
	private static final int 		USER_LASTNAME_INDEX = 2;
	private static final int 		USER_PASSWORD_INDEX = 3;
	private static final int 		USER_EMAIL_INDEX = 4;
	
	private static DefaultUserStoringService instance;
	private final File file;
	
	static {
		instance = null;
	}
	
	public static DefaultUserStoringService getInstance() {
		if(instance == null) {
			instance = new DefaultUserStoringService();
		}
		return instance;
	}
	
	private String convertToStorableString(User user) {
		String storableUser = user.getId() + "," +
				user.getFirstName() + "," + 
				user.getLastName() + "," + 
				user.getPassword() + "," + 
				user.getEmail();
		return storableUser;
	}

	@Override
	public void saveUser(User user) {
		try {
			Files.writeString(Paths.get(ROOT_RESOURCES_FOLDER, USER_STORAGE_RESOURCE_FOLDER, USER_STORAGE_FILENAME), 
					System.lineSeparator() + convertToStorableString(user).getBytes(), 
					StandardCharsets.UTF_8,
					StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> loadUsers() {
		try (var stream = Files.lines(Paths.get(ROOT_RESOURCES_FOLDER, USER_STORAGE_RESOURCE_FOLDER, USER_STORAGE_FILENAME))) {
			return stream.filter(Objects::nonNull)
					.filter(line -> !line.isEmpty())
					.map(line -> {
						String[] userElements = line.split(",");
						return new DefaultUser(Integer.valueOf(userElements[USER_ID_INDEX]),
								userElements[USER_FIRSTNAME_INDEX],
								userElements[USER_LASTNAME_INDEX],
								userElements[USER_PASSWORD_INDEX],
								userElements[USER_EMAIL_INDEX]);
					})
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
