package com.github.ronanquillevere.bvc.crawler.infrastructure.youtube;

import java.util.List;

import org.jsoup.nodes.Document;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataInjector;
import com.github.ronanquillevere.bvc.crawler.domain.video.Video;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.JsoupDataFetcher;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube.YoutubeJsoupParser;
import com.google.inject.Inject;

public class YoutubeDataInjector implements DataInjector {

	private JsoupDataFetcher dataFetcher;
	private YoutubeJsoupParser parser;

	@Inject
	public YoutubeDataInjector(JsoupDataFetcher dataFetcher,
			YoutubeJsoupParser parser) {
		this.dataFetcher = dataFetcher;
		this.parser = parser;
	}

	public List<Video> fetchData() {
		Document data = dataFetcher.fetchData("https://www.youtube.com/results?search_query=cover");
		return parser.parse(data);
	}

}
