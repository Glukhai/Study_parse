package kurs;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FinIua {
	
	
	public Document getFinIua() throws IOException {
		Document doc = Jsoup.connect("http://finance.i.ua/nbu/").timeout(0000).get();
//System.out.println(doc);
		return doc;
	}

	public String parse(Document doc){
		Element tagElements = doc.tagName("td class");
	Elements elem = tagElements.select("tr");
		
		String value = (String)elem.html();
		int firstIdxUSD = value.indexOf("США");
		int firstIdxEur =  value.indexOf("Евро");
		
		String strUsd = value.substring(firstIdxUSD+49, firstIdxUSD+55);
		String strEur = value.substring(firstIdxEur+50, firstIdxEur+56);
		
		System.out.println(value);
		
		System.out.println(strUsd+"\n");
		System.out.println(strEur);
		String usd = (String) value.subSequence(151, 169);
	//	String usd1 = usd.substring(8,17);
		return value;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		FinIua finIua = new FinIua();
		Document doc = finIua.getFinIua();
		finIua.parse(doc);
		
		//System.out.println(finIua.parse(finIua.getFinIua())); 
		
	}
}
