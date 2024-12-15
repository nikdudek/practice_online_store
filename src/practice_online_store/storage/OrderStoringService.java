package practice_online_store.storage;

import java.util.List;

import practice_online_store.enteties.Order;

public interface OrderStoringService {

	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
	
}
