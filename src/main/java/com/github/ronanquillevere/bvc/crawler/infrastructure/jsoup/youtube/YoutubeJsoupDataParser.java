package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataParser;
import com.github.ronanquillevere.bvc.crawler.domain.video.Video;
import com.github.ronanquillevere.bvc.crawler.domain.video.WebSite;

public class YoutubeJsoupDataParser implements DataParser<Document>{

	private static final String CLASS_META_INFO = "yt-lockup-meta-info";

	private Logger logger = LoggerFactory.getLogger(YoutubeJsoupDataParser.class);
	
	private static final String ATTRIBUTE_HREF = "href";
	private static final String YOUTUBE_URL = "http://www.youtube.com";

	private static final String CLASS_ITEM_SECTION = "item-section";
	private static final String CLASS_UPLOADER = "yt-lockup-byline";
	private static final String CLASS_TITLE = "yt-lockup-title";
	private static final String CLASS_DESCRIPTION = "yt-lockup-description";
	private static final String CLASS_YT_VIDEO = "yt-lockup-video";

	private static final String ID_RESULTS = "results";
	
	@Override
	public List<Video> parse(Document doc) {
		List<Video> videos = new ArrayList<Video>(); // TODO @rqu

		Element results = doc.getElementById(ID_RESULTS);

		Elements itemSection = results.getElementsByClass(CLASS_ITEM_SECTION);
		Iterator<Element> it = itemSection.iterator();
		while (it.hasNext()) {
			parseSection(videos, it.next());
		}

		return videos;
	}

	private void parseSection(List<Video> videos, Element item) {
		
		Elements items = item.getElementsByClass(CLASS_YT_VIDEO);
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
		int views = extractViews(item, CLASS_META_INFO);
		Video v = new Video(YoutubeHelper.extractId(url), title, description, uploader, views, url, WebSite.Youtube);
		videos.add(v);
		logger.info("Parsed;" + v);
	}

	private int extractViews(Element item, String className) {
		String views = item.getElementsByClass(className).get(0).children().get(1).html();
		views = StringEscapeUtils.unescapeHtml4(views).trim();
		views = views.replaceAll("[^1-9]", "");
		return Integer.valueOf(views);
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
		return StringEscapeUtils.unescapeHtml4(item.getElementsByClass(className).get(0).getElementsByTag("a").get(0).html());
	}
	
	private String extractSimpleElementByClassName(Element item, String className) {
		return StringEscapeUtils.unescapeHtml4(item.getElementsByClass(className).html());
	}
}
