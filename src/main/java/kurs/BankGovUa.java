package kurs;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class BankGovUa extends Thread {
	private static String file1 = "d:/trade.txt";
	
	public static void main(String[] args) throws IOException, InterruptedException {
			 
		BankGovUa bank = new BankGovUa();
		
				Document doc =bank.getGov();
				
			  String USD =  bank.parseUSD(doc);
			 System.out.println(USD);
			 
	}
	
	public Document getGov()  throws IOException {
		Document doc = Jsoup.connect("https://bank.gov.ua/control/uk/curmetal/detail/currency?period=daily")
				
			.timeout(000)	
		.get();
				
		
		return doc;
	}
	
	
	public String parseUSD (Document doc){
		Elements tagElements = doc.getElementsByAttributeValue("class", "cell_c");
		String value = (String)tagElements.html();
			String usd =value.substring(158, 169);
	
		return usd;
		
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
	public void showSwing (String USD, String EUR){
		JFrame myWindow = new JFrame("Пробное окно");
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setSize(200, 200);
		myWindow.setVisible(true);
		JPanel panelUSD = (JPanel) new JPanel();
		JPanel panelEUR = (JPanel) new JPanel();
		panelUSD.add(new JLabel("USD: " + USD));
		panelUSD.add(new JLabel("EUR: " + EUR));
		//panelUSD.setLayout(new FlowLayout());
		myWindow.add(panelUSD);
		//myWindow.add(panel.add(new JLabel("EUR:" + EUR)));
		
		
	}
	
	public void clipboard(String value){
		 StringSelection ss = new StringSelection(value);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
	}
}



