package jsoup1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class secondJsoup {
	public static void main(String[] args) throws IOException {
		List<Article> articlist = new ArrayList<>();

		Document doc = Jsoup.connect("http://4pda.ru").get();
		// парсинг:
		Elements h1Elements = doc.getElementsByAttributeValue("class", "list-post-title");
		// поиск элементов по 2-м значениям "class", "list-post-title"
		// получили все статьи на странице
		h1Elements.forEach(h1Element -> { 
			// пробежатся, по статьям
			Element aElement = h1Element.child(0);
			// достаем из h1 ссылку
			// вірезаем с атрибута
			String url = aElement.attr("href");
			String title = aElement.child(0).text();
			articlist.add(new Article(url, title));

		});
		articlist.forEach(System.out::println);
	}
}
	class Article{
		
		private String url;
		private String name;
				
		public Article(String url, String name) {
			super();
			this.url = url;
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Article [url=" + url + ", name=" + name + "]";
		}
		
		
		
	}



