package com.github.ronanquillevere.bvc.crawler.domain.crawling;

import java.io.IOException;

public interface DataFetcher<T> {
	T fetchData(String url) throws IOException;
}
