package com.github.ronanquillevere.bvc.crawler.application;

import injection.MyModule;

import com.github.ronanquillevere.bvc.crawler.application.crawling.Crawler;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application {
	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new MyModule());
		
		Crawler crawler = injector.getInstance(Crawler.class);
		
		crawler.crawl();
	}
}
