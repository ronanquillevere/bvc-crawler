package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup;

import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataFetcher;

public class MockDataFetcher implements DataFetcher<Document> {
	
	private Logger logger = LoggerFactory.getLogger(OnlineDataFetcher.class);
	
	@Override
	public Document fetchData(String url) throws IOException {
		String fileName = "fake.html";
		Document doc = readDocumentFromFile(this.getClass(), fileName);
		logger.info("Fetched;" + fileName);
		return doc;
	}
	
	public static Document readDocumentFromFile(Class<?> type, String fileName)
			throws IOException {
		InputStream mockYoutubePageStrem = null;
		try {
			mockYoutubePageStrem = type.getResourceAsStream(fileName);

			return Jsoup.parse(mockYoutubePageStrem, "UTF-8", "");

		} finally {
			if (mockYoutubePageStrem != null)
				mockYoutubePageStrem.close();
		}
	}

}
