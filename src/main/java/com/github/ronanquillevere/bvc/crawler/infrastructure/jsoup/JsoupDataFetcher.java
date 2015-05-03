package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupDataFetcher {

	boolean offline = true;
	
	//@CheckforNull
	public Document fetchData(String url) {

		Document doc;
		try {
			if (!offline) {
				doc = Jsoup.connect(url)
						.get();
			} else {
				File file = new File("fake.html");
				doc = Jsoup.parse(file, "UTF-8");
			}
		} catch (IOException e) {
			throw new RuntimeException("Not retrieved data;youtube");
		}

		return doc;
	}

	

}
