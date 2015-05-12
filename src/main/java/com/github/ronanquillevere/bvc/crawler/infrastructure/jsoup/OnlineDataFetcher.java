package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataFetcher;

public class OnlineDataFetcher implements DataFetcher<Document> {

	private Logger logger = LoggerFactory.getLogger(OnlineDataFetcher.class);

	@Override
	public Document fetchData(String url) throws IOException {

		Document doc;
		doc = Jsoup.connect(url).get();
		logger.info("Fetched;" + url);

		return doc;
	}

}
