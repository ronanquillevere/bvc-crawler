package com.github.ronanquillevere;

import java.io.IOException;

import com.github.ronanquillevere.bvc.crawler.application.crawling.Crawler;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.JsoupDataFetcher;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.JsoupYoutubeParser;
import com.github.ronanquillevere.bvc.crawler.infrastructure.youtube.YoutubeDataFetcherImpl;

public class App {
	public static void main(String[] args) throws IOException {

		//TODO @rqu injection
		JsoupDataFetcher dataFetcher = new JsoupDataFetcher();
		JsoupYoutubeParser parser = new JsoupYoutubeParser();
		
		Crawler crawler = new Crawler(new YoutubeDataFetcherImpl(dataFetcher, parser));
		crawler.crawl();

	}
}
