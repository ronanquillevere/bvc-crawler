package com.github.ronanquillevere.bvc.crawler.domain.video;

import com.github.ronanquillevere.bvc.crawler.domain.common.HasId;
import com.google.common.base.Objects.ToStringHelper;

public class Video implements HasId {
	private ToStringHelper stringHelper = com.google.common.base.Objects.toStringHelper(Video.class);
	private final String title;
	
	private final String description;
	private final String uploader;
	private final int views;
	private final String url;
	private final String id;
	private final WebSite website;

	public Video(String id, String title, String description, String uploader, int views, String url, WebSite website) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.uploader = uploader;
		this.views = views;
		this.url = url;
		this.website = website;
	}

	@Override
	public String getId() {
		return id;
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
	
	public WebSite getWebsite() {
		return website;
	}

	@Override
	public String toString() {
		stringHelper.add("id", id);
		stringHelper.add("title", title);
		//stringHelper.add("views", views);
		stringHelper.add("url", url);
		return stringHelper.toString();
	}
}
