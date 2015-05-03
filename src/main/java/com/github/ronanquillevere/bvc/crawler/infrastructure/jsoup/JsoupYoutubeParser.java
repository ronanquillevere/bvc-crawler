package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;

public class JsoupYoutubeParser {
	private static final String ATTRIBUTE_HREF = "href";
	private static final String CLASS_UPLOADER = "yt-lockup-byline";
	private static final String CLASS_TITLE = "yt-lockup-title";
	private static final String CLASS_DESCRIPTION = "yt-lockup-description";
	private static final String YOUTUBE_URL = "http://www.youtube.com";

	public List<Video> parseDoc(Document doc) {
		List<Video> videos = new ArrayList<Video>(); // TODO @rqu

		Element results = doc.getElementById("results");

		Elements itemSection = results.getElementsByClass("item-section");
		Iterator<Element> it = itemSection.iterator();
		while (it.hasNext()) {
			parseSection(videos, it.next());
		}

		return videos;
	}

	private void parseSection(List<Video> videos, Element item) {
		Elements items = item.getElementsByClass("b;erwdvjbsa'jbo"); slcjbADV:JB;jb
		Iterator<Element> it2 = items.iterator();
		while (it2.hasNext()) {
			parseItem(videos, it2.next());
		}
	}

	private void parseItem(List<Video> videos, Element item) {
		String title = extractTitle(item, CLASS_TITLE);
		String description = extractSimpleElementByClassName(item, CLASS_DESCRIPTION);
		String uploader = extractUploader(item, CLASS_UPLOADER);
		String url = extractUrl(item, CLASS_TITLE);
		
		System.out.println("Cover title : " + title);
		Video v = new Video(title, description, uploader, 0, url);
		videos.add(v);
	}

	private String extractUrl(Element item, String className) {
		Element anchor = item.getElementsByClass(className).get(0).getElementsByTag("a").get(0);
		return YOUTUBE_URL + anchor.attr(ATTRIBUTE_HREF);
	}

	private String extractUploader(Element item, String className) {
		return extractFirstAnchorValue(item, className);
	}

	private String extractTitle(Element item, String className) {
		return extractFirstAnchorValue(item, className);
	}
	
	private String extractFirstAnchorValue(Element item, String className) {
		return item.getElementsByClass(className).get(0).getElementsByTag("a").get(0).html();
	}
	
	private String extractSimpleElementByClassName(Element item, String className) {
		return item.getElementsByClass(className).html();
	}
}
