package com.github.ronanquillevere.bvc.crawler.infrastructure.youtube;

import java.util.List;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;
import com.github.ronanquillevere.bvc.crawler.domain.youtube.YoutubeDataFetcher;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.JsoupDataFetcher;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.JsoupYoutubeParser;

public class YoutubeDataFetcherImpl implements YoutubeDataFetcher {

	private JsoupDataFetcher dataFetcher;
	private JsoupYoutubeParser parser;

	public YoutubeDataFetcherImpl(JsoupDataFetcher dataFetcher,
			JsoupYoutubeParser parser) {
		this.dataFetcher = dataFetcher;
		this.parser = parser;
	}

	public List<Video> fetchData() {
		return parser
				.parseDoc(dataFetcher
						.fetchData("https://www.youtube.com/results?search_query=cover"));
	}

}
