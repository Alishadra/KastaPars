package ua.kasta.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ua.kasta.model.Item;

public class DataPageService {

	
	public static List<String> getItem(String URL) {

		
		List<String> item = new ArrayList<>();
		Item it = new Item();
		Document document = null;

		try {
			document = Jsoup.connect(URL).get();

			it.setImgURL(getImgURL(document));
			it.setName(getName(document));
			it.setPrice(getPrice(document));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return item;

	}

	private static Integer getPrice(Document document) {

		Elements priceElements = document.getElementsByTag("span");
		for (Element element : priceElements) {

			if (element.hasAttr("class") && element.hasAttr("data-reactid")
					&& element.attr("class").equals("product_item__new-cost")) {
				String span = element.text();
				int price = Integer.parseInt(span);
				return price;
			}

		}

		return null;
	}

	private static String getName(Document document) {

		Elements nameElements = document.getElementsByTag("img");
		for (Element element : nameElements) {
			if (element.hasAttr("alt") && element.hasAttr("data-reactid") && element.hasAttr("src")) {
				return element.attr("alt");
			}

		}

		return "";
	}

	private static String getImgURL(Document document) {

		Elements imgElements = document.getElementsByTag("img");
		for (Element element : imgElements) {
			if (element.hasAttr("alt") && element.hasAttr("data-reactid") && element.hasAttr("src")) {
				return element.attr("src");
			}

		}

		return "";
	}

}
