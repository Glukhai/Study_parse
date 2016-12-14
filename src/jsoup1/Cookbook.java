package jsoup1;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Cookbook {

	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect("https://www.olx.ua/nedvizhimost/prodazha-pomescheniy/"	).get();

		Element content = doc.getElementById("href");
		Elements links = content.getElementsByTag("href");
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  String linkText = link.text();
	
		System.out.println(linkHref);
		System.out.println(linkText);
		}
}
}