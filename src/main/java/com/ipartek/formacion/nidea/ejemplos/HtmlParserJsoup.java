package com.ipartek.formacion.nidea.ejemplos;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserJsoup {

	public static void main(String[] args) throws IOException {

		String url = "http://http://localhost:8080/nidea";

		Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).data("usuario", "admin").data("password", "admin").execute();

		Document doc = response.parse();
		System.out.println(doc.getElementsByTag("h1").get(0).text());

		Elements anclas = doc.getElementsByTag("a");

		for (Element ancla : anclas) {
			String urlPagina2 = ancla.attr("href");
			if (urlPagina2.equals("materiales")) {
				Document doc2 = Jsoup.connect(urlPagina2).get();
				System.out.println("Titulo pagina " + doc2.title());
			}

		}

		Element enlace1 = doc.getElementById("a");
		String enlace2 = enlace1.attr("href");

	}
}