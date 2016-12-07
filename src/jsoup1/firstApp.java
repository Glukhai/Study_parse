package jsoup1;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class firstApp {
	
	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://jsoup.org").get();
		Document doc1 = Jsoup.connect("http://tables.finance.ua/ru/currency/official/-/1").get();
		
		Element link = doc.select("a").first();
		String relHref = link.attr("href"); // == "/"
		String absHref = link.attr("abs:href"); // "http://jsoup.org/"
		System.out.println(doc1.title());
	//	System.out.println(relHref.);
		

	}
	
}
