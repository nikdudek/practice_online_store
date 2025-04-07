package practice_online_store.storage.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import practice_online_store.enteties.Order;
import practice_online_store.storage.OrderStoringService;

public class DefaultOrderStoringService implements OrderStoringService {
	
	private static final String 	ORDER_STORAGE_FILENAME = "orders.data";
	private static final String 	ROOT_RESOURCES_FOLDER = "practice_online_store";
	private static final String		ORDERS_STORAGE_RESOURCE_FOLDER = "resources";
	
	private static DefaultOrderStoringService instance;
	
	private DefaultOrderStoringService() {
	}
	
	public static DefaultOrderStoringService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderStoringService();
		}
		return instance;
	}

	@Override
	public void saveOrders(List<Order> order) {
		try (var oos = new ObjectOutputStream(new FileOutputStream(ROOT_RESOURCES_FOLDER +
				File.separator + ORDERS_STORAGE_RESOURCE_FOLDER +
				File.separator + ORDER_STORAGE_FILENAME))) {
			oos.writeObject(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> loadOrders() {
		try (var ois = new ObjectInputStream(new FileInputStream(ROOT_RESOURCES_FOLDER +
				File.separator + ORDERS_STORAGE_RESOURCE_FOLDER +
				File.separator + ORDER_STORAGE_FILENAME))) {
			return (List<Order>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
