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

	public static List<Item> getItem(String URL) {

		List<Item> items = new ArrayList<>();
		Document document = null;

		try {
			document = Jsoup.connect(URL).get();

			// need collect ALL tags with items

			Elements itemElements = document.getElementsByClass("product__item");

			for (Element itemElement : itemElements) {
				Item item = new Item();

				item.setImgURL(getImgURL(itemElement));
				item.setName(getName(itemElement));
				item.setPrice(getPrice(itemElement));

				// add item to collection
				items.add(item);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;

	}

	private static Integer getPrice(Element itemElement) {

		Elements priceElements = itemElement.getElementsByTag("span");
		for (Element element : priceElements) {

			if (element.hasAttr("class") && element.hasAttr("data-reactid")
					&& element.attr("class").equals("product_item__new-cost")) {
				String span = element.text();
				int price = Integer.parseInt(span.replaceAll("\\D", ""));
				return price;
			}

		}

		return null;
	}

	private static String getName(Element itemElement) {

		Elements nameElements = itemElement.getElementsByTag("img");
		for (Element element : nameElements) {
			if (element.hasAttr("alt") && element.hasAttr("data-reactid") && element.hasAttr("src")) {
				return element.attr("alt");
			}

		}

		return "";
	}

	private static String getImgURL(Element itemElement) {
		
			Elements imgElements = itemElement.getElementsByTag("img");
			for (Element element : imgElements) {
				if (element.hasAttr("alt") && element.hasAttr("data-reactid") && element.hasAttr("src")) {
					return element.attr("src");

			}
		}

		

		return "";
	}

}