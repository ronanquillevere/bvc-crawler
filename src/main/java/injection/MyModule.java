package injection;

import org.jsoup.nodes.Document;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataCrawler;
import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataFetcher;
import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataParser;
import com.github.ronanquillevere.bvc.crawler.domain.video.WebSiteNames;
import com.github.ronanquillevere.bvc.crawler.infrastructure.crawling.youtube.YoutubeDataCrawler;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.MockDataFetcher;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.OnlineDataFetcher;
import com.github.ronanquillevere.bvc.crawler.infrastructure.jsoup.youtube.YoutubeJsoupDataParser;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class MyModule extends AbstractModule {
	private static final String MODE_ONLINE = "online";
	private static final String MODE_OFFLINE = "offline";
	public static final String MODE = MODE_OFFLINE;

	@Override
	protected void configure() {
		bind(DataCrawler.class).to(YoutubeDataCrawler.class);
		
		bind(new TypeLiteral<DataFetcher<Document>>(){}).annotatedWith(Names.named(MODE_OFFLINE)).to(
				MockDataFetcher.class);
		bind(new TypeLiteral<DataFetcher<Document>>(){}).annotatedWith(Names.named(MODE_ONLINE)).to(
				OnlineDataFetcher.class);
		bind(new TypeLiteral<DataParser<Document>>(){}).annotatedWith(Names.named(WebSiteNames.YOUTUBE)).to(
				YoutubeJsoupDataParser.class);
	}
}
