package com.github.ronanquillevere.bvc.crawler.application.crawling;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataCrawler;
import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public class Crawler {
	
	private DataCrawler dataCrawler;
	
	Logger logger = LoggerFactory.getLogger(Crawler.class);
	
	
	@Inject
	public Crawler(DataCrawler crawler) {
		this.dataCrawler = crawler;
	}
	
	public void crawl(){
		String url = "https://www.youtube.com/results?search_query=cover";
		List<Video> videos = dataCrawler.crawl(url);
		logger.info("Crawled videos;" + videos.size());
	}
}
