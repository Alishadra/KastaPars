package ua.kasta.multithread;

import java.io.IOException;
import java.util.List;

import ua.kasta.model.Item;
import ua.kasta.service.DataPageService;
import ua.kasta.service.FileManager;

public class Multithread extends Thread {
	private static final String URL = "https://kasta.ua/market/platya";
	private DataPageService dataPageService;

	public Multithread(DataPageService dataPageService) {
		this.dataPageService = dataPageService;
	}

	@Override
	public void run() {

		try {
			List<String> dataPage = DataPageService.getItem(URL);
			for (String dataPages : dataPage) {
				FileManager.writeDataPageServiceToFile(dataPageService);
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
