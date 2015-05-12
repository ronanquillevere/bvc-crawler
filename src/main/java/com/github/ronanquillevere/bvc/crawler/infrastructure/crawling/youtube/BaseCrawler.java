package com.github.ronanquillevere.bvc.crawler.infrastructure.crawling.youtube;

import java.io.IOException;
import java.util.List;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataCrawler;
import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataFetcher;
import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataParser;
import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public class BaseCrawler<T> implements DataCrawler{
	
	private final DataFetcher<T> dataFetcher;
	private final DataParser<T> parser;

	public BaseCrawler(DataFetcher<T> dataFetcher,
			DataParser<T> parser) {
		this.dataFetcher = dataFetcher;
		this.parser = parser;
	}
	
	public List<Video> crawl(String url) {
		T data;
		try {
			data = dataFetcher.fetchData(url);
		} catch (IOException e) {
			throw new RuntimeException("Failed to fetch data;" + url, e);
		}
		return parser.parse(data);
	}
}
