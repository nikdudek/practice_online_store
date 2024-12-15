package practice_online_store.storage;

import java.util.List;

import practice_online_store.enteties.User;

public interface UserStoringService {

	void saveUser(User user);
	
	List<User> loadUsers();
	
}
