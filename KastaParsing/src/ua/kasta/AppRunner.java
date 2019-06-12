package ua.kasta;

import java.util.List;

import ua.kasta.model.Item;
import ua.kasta.multithread.Multithread;
import ua.kasta.service.DataPageService;

public class AppRunner {

	private static final String URL = "https://kasta.ua/market/platya";

	public static void main(String[] args) {
		
		
		List<String> dataPage = DataPageService.getItem(URL);
		for (String dataPages : dataPage) {
			Multithread multithread = new Multithread(dataPage);
			multithread.start();
		}
		
	}

}
