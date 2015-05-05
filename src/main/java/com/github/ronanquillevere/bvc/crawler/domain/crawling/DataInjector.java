package com.github.ronanquillevere.bvc.crawler.domain.crawling;

import java.util.List;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public interface DataInjector {
	public List<Video> fetchData();
}
