package com.github.ronanquillevere.bvc.crawler.infrastructure.crawling.youtube;

import injection.MyModule;

import javax.inject.Named;

import org.jsoup.nodes.Document;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataFetcher;
import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataParser;
import com.github.ronanquillevere.bvc.crawler.domain.video.WebSiteNames;
import com.google.inject.Inject;

public class YoutubeDataCrawler extends BaseCrawler<Document> {

	@Inject
	public YoutubeDataCrawler(
			@Named(MyModule.MODE) DataFetcher<Document> dataFetcher,
			@Named(WebSiteNames.YOUTUBE) DataParser<Document> parser) {
		super(dataFetcher, parser);
	}

}
