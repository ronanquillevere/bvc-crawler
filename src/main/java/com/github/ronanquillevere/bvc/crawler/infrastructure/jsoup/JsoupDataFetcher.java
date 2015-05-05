package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsoupDataFetcher {
	
	private Logger logger = LoggerFactory.getLogger(JsoupDataFetcher.class);
	boolean offline = true;
	
	public Document fetchData(String url) {

		Document doc;
		try {
			if (!offline) {
				doc = Jsoup.connect(url).get();
				logger.info("Fetched;" + url);
			} else {
				String mock = "fake.html";
				File file = new File(mock);
				doc = Jsoup.parse(file, "UTF-8");
				logger.info("Fetched;" + mock);
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to fetch;" + url);
		}

		return doc;
	}

	

}
