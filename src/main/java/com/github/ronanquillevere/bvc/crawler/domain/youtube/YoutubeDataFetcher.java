package com.github.ronanquillevere.bvc.crawler.domain.youtube;

import java.util.List;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public interface YoutubeDataFetcher {
	public List<Video> fetchData();
}
