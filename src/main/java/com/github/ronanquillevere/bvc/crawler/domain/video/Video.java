package com.github.ronanquillevere.bvc.crawler.domain.video;

public class Video {
	private final String title;
	private final String description;
	private final String uploader;
	private final int views;
	private final String url;

	public Video(String title, String description, String uploader, int views, String url) {
		this.title = title;
		this.description = description;
		this.uploader = uploader;
		this.views = views;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUploader() {
		return uploader;
	}

	public int getViews() {
		return views;
	}

	public String getUrl() {
		return url;
	}
}
