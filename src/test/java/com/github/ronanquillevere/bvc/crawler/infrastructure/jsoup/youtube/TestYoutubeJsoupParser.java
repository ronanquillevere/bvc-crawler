package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import com.github.ronanquillevere.bvc.crawler.domain.video.Video;
import com.github.ronanquillevere.bvc.crawler.domain.video.WebSite;

public class TestYoutubeJsoupParser {
	
	private Document doc;

	@Before
	public void setup() throws IOException{
		InputStream mockYoutubePageStrem = null;
		try {
			mockYoutubePageStrem = this.getClass().getResourceAsStream("fake.html");
			
			doc = Jsoup.parse(mockYoutubePageStrem, "UTF-8", "");
		
		} finally {
			if (mockYoutubePageStrem != null)
				mockYoutubePageStrem.close();
		}
	}
	
	@Test
	public void testParse() throws Exception {
			YoutubeJsoupParser parser = new YoutubeJsoupParser();
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
