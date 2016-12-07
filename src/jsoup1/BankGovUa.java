package jsoup1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BankGovUa {
	private static String file1 = "d:/trade.txt";
	
	public static void main(String[] args) throws IOException {
			  BankGovUa bank = new BankGovUa();
			  String USD = bank.parseUSD(bank.get());
			  String EUR = bank.parseEUR(bank.get());
			  bank.print(USD, EUR);
			  bank.write(USD, EUR);
	}
	
	public String get() throws IOException{
		Document doc = Jsoup.connect("https://bank.gov.ua/control/uk/curmetal/detail/currency?period=daily").get();
		Elements tagElements = doc.getElementsByAttributeValue("class", "cell_c");
		String value = tagElements.html();
		return value;
	}
	
	public String parseUSD (String text){
	//	List<String> tradeList = new ArrayList<>();
		String value = text;
		String usd = (String) value.subSequence(151, 169);
		String usd1 = usd.substring(8,17);
		return usd1;
		
	}
	
	public String parseEUR (String text){
		char [] ch;
		String value = text;
		String eur = (String) value.subSequence(173, 190);
		String eur1 = eur.substring(8,17);
		//Integer eurInt = Integer.parseInt(eur1);
		//System.out.println(eurInt);
		return eur1;
		
	}
	
	public void write(String USD,String EUR) throws IOException{
		
		FileWriter file = new FileWriter(file1);
		file.write("USD: "+USD +"\n");
		file.write("EUR: "+ EUR+"\n");
		file.flush();
		file.close();
		
	}
	
	public void print(String USD, String EUR){
		System.out.println("VAL USD:" + USD);
		System.out.println("VAL EUR:" + EUR);
		
	}
	
}




