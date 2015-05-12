package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;
import com.github.ronanquillevere.bvc.crawler.domain.video.WebSite;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.MockDataFetcher;

public class TestYoutubeJsoupParser {

	private Document doc;

	@Before
	public void setup() throws IOException {
		String fileName = "fake.html";
		doc = MockDataFetcher.readDocumentFromFile(this.getClass(), fileName);
	}

	@Test
	public void testParse() throws Exception {
		YoutubeJsoupDataParser parser = new YoutubeJsoupDataParser();
		List<Video> videos = parser.parse(doc);

		String id = "ekuAKqo51ps";
		String title = "Elastic Heart - Sia - Madilyn Bailey & KHS Cover";
		String description = "Hope you like our version of Elastic Heart! If you do, support us and grab it at:Ê...";
		String url = "http://www.youtube.com/watch?v=ekuAKqo51ps";
		String uploader = "Kurt Hugo Schneider";

		assertThat(videos.size()).isEqualTo(20);
		assertThat(videos.get(0).getId()).isEqualTo(id);
		assertThat(videos.get(0).getTitle()).isEqualTo(title);
		assertThat(videos.get(0).getDescription()).isEqualTo(description);
		assertThat(videos.get(0).getUrl()).isEqualTo(url);
		assertThat(videos.get(0).getViews()).isEqualTo(1828945);
		assertThat(videos.get(0).getUploader()).isEqualTo(uploader);
		assertThat(videos.get(0).getWebsite()).isEqualTo(WebSite.Youtube);

	}
}
