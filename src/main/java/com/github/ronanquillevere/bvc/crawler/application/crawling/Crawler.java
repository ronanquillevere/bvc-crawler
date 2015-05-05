package com.github.ronanquillevere.bvc.crawler.application.crawling;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataInjector;
import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public class Crawler {
	
	private DataInjector dataInjector;
	
	Logger logger = LoggerFactory.getLogger(Crawler.class);
	
	
	@Inject
	public Crawler(DataInjector dataInjector) {
		this.dataInjector = dataInjector;
	}
	public void crawl(){
		List<Video> videos = dataInjector.fetchData();
		logger.info("Crawled videos;" + videos.size());
	}
}
