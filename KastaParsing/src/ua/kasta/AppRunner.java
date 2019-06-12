package ua.kasta;

import java.io.IOException;
import java.util.List;

import ua.kasta.model.Item;
import ua.kasta.service.DataPageService;
import ua.kasta.service.FileManager;

public class AppRunner {

	private static final String URL = "https://kasta.ua/market/platya";

	public static void main(String[] args) {
		
		
		List<Item> items = DataPageService.getItem(URL);
		for (Item item : items) {
			try {
				FileManager.writeDataPageServiceToFile(item, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

		
		}
		

