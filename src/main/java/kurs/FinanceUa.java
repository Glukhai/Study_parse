package kurs;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class FinanceUa {

	public static void main(String[] args) {
	   FinanceUa finua =new FinanceUa();
	   try {
		
		  System.out.println(finua.get());
		
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	   

	}
	public Document get() throws IOException, InterruptedException{
		Document doc = Jsoup.connect("http://tables.finance.ua/ru/currency/official/").get();
	
		
	//	System.out.println(tagElements);
		
		return doc;
}
	public String parse(Document doc){
		Document doc1 = doc;
		
		
		Elements tagElements = doc.getElementsByAttributeValue("class", "topcurs1 haslink");
		String value = tagElements.html();
		
		return value;
		
		
		
	}
}