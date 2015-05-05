package com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube;

import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;

public class TestYoutubeHelper {
	@Test
	public void testExtractId() throws Exception {
		//Given
		
		//When
		String id = "QU4F2v7-9KQ";
		String extracted = YoutubeHelper.extractId("http://www.youtube.com/watch?v=" + id);
		
		//Then
		assertThat(extracted).isEqualTo(id);
	}
}
