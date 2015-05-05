package com.github.ronanquillevere.bvc.crawler.domain.video;

public enum WebSite {
	Youtube {
		@Override
		public <IN, OUT> OUT accept(WebSiteVisitor<IN, OUT> visitor, IN in) {
			return visitor.visitYoutube(in);
		}
	},
	DailyMotion {
		@Override
		public <IN, OUT> OUT accept(WebSiteVisitor<IN, OUT> visitor, IN in) {
			return visitor.visitDailyMotion(in);
		}
	};

	public abstract <IN, OUT> OUT accept(WebSiteVisitor<IN, OUT> visitor, IN in);

	public interface WebSiteVisitor<IN, OUT> {
		OUT visitYoutube(IN in);

		OUT visitDailyMotion(IN in);
	}
}
