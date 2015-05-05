package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup;

import java.util.List;

import org.jsoup.nodes.Document;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public interface JsoupParser {
	List<Video> parse(Document document); 
}
