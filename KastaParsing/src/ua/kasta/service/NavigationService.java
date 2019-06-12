//package ua.kasta.service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class NavigationService {
//
//	private static final String BASE_URL = "https://kasta.ua";
//
//	public static List<String> getNavigationLinks() {
//
//		List<String> navigationLinks = new ArrayList();
//
//		try {
//			Document document = Jsoup.connect(BASE_URL).get();
//			Elements marketElement = document.getElementsByAttribute("1975");
//			Elements dataElements = marketElement.tagName("data-reactid");
//			Elements divElements = dataElements.tagName("div");
//
//			for (Element divElement : divElements) {
//
//				Elements imgElements = divElement.getElementsByTag("img");
//				for (Element imgElement : imgElements) {
//
//					navigationLinks.add(imgElement.attr("src"));
//					navigationLinks.add(imgElement.attr("alt"));
//
//				}
//				
//				Elements spanElements = divElement.getElementsByTag("span");
//				for (Element spanElement : spanElements) {
//					navigationLinks.add(spanElement.text());
//				}
//
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return navigationLinks;
//
//	}
//
//}
