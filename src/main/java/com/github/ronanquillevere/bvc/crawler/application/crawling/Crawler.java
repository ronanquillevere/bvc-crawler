package com.github.ronanquillevere.bvc.crawler.application.crawling;

import java.util.List;

import javax.inject.Inject;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;
import com.github.ronanquillevere.bvc.crawler.domain.youtube.YoutubeDataFetcher;

public class Crawler {
	
	private YoutubeDataFetcher youtubeDataFetcher;
	
	@Inject
	public Crawler(YoutubeDataFetcher youtubeDataFetcher) {
		this.youtubeDataFetcher = youtubeDataFetcher;
	}
	public void crawl(){
		List<Video> videos = youtubeDataFetcher.fetchData();
		
		System.out.println("Crawled videos;" + videos.size()); //TODO @rqu slf
	}
}
