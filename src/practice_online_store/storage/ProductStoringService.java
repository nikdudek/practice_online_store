package practice_online_store.storage;

import java.util.List;

import practice_online_store.enteties.Product;

public interface ProductStoringService {

	List<Product> loadProducts();
	
}
