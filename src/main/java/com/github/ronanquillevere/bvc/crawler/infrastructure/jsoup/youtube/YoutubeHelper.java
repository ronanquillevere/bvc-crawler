package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube;

public class YoutubeHelper {
	private YoutubeHelper() {
	}

	public static String extractId(String url) {
		return url.substring(url.lastIndexOf("=")+1);
	}
}
