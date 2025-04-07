package practice_online_store.storage.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import practice_online_store.enteties.Product;
import practice_online_store.enteties.impl.DefaultProduct;
import practice_online_store.storage.ProductStoringService;

public class DefaultProductStoringService implements ProductStoringService {
	
	private static final String 	PRODUCT_STORAGE_FILENAME = "products.csv";
	private static final String 	ROOT_RESOURCES_FOLDER = "practice_online_store";
	private static final String		PRODUCT_STORAGE_RESOURCE_FOLDER = "resources";
	private static final int 		PRODUCT_ID_INDEX = 0;
	private static final int 		PRODUCT_PRODUCTNAME_INDEX = 1;
	private static final int 		PRODUCT_CATEGORYNAME_INDEX = 2;
	private static final int 		PRODUCT_PRICE_INDEX = 3;
	
	private static DefaultProductStoringService instance;
	
	private DefaultProductStoringService() {
	}
	
	public static DefaultProductStoringService getInstance() {
		if (instance == null) {
			instance = new DefaultProductStoringService();
		}
		return instance;
	}

	@Override
	public List<Product> loadProducts() {
		try (var stream = Files.lines(Paths.get(ROOT_RESOURCES_FOLDER, PRODUCT_STORAGE_RESOURCE_FOLDER, PRODUCT_STORAGE_FILENAME))) {
			return stream.filter(Objects::nonNull)
					.filter(line -> !line.isEmpty())
					.map(line -> {
						String[] userElements = line.split(",");
						return new DefaultProduct(Integer.valueOf(userElements[PRODUCT_ID_INDEX]),
								userElements[PRODUCT_PRODUCTNAME_INDEX],
								userElements[PRODUCT_CATEGORYNAME_INDEX],
								Double.valueOf(userElements[PRODUCT_PRICE_INDEX]));
					})
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
