package injection;

import com.github.ronanquillevere.bvc.crawler.domain.crawling.DataInjector;
import com.github.ronanquillevere.bvc.crawler.infrastructure.youtube.YoutubeDataInjector;
import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule{
	@Override
    protected void configure()
    {
        bind(DataInjector.class).to(YoutubeDataInjector.class);
    }
}
