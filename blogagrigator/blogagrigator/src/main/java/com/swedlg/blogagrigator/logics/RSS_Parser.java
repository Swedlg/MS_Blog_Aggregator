package com.swedlg.blogagrigator.logics;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.swedlg.blogagrigator.models.RSSItemModel;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSS_Parser {

    ArrayList<SyndFeed> feeds = new ArrayList<>();

    public RSS_Parser(String[] urls){
        try {
            //Пример URL адреса RSS ленты https://anshamshev.wordpress.com/feed/rss/
            for (var url: urls) {
                URL feedSource = new URL(url);
                SyndFeedInput input = new SyndFeedInput();
                feeds.add(input.build(new XmlReader(feedSource)));
            }
            System.out.println("");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<RSSItemModel> GetItemsRSSFeed(){

        List<RSSItemModel> result = new ArrayList<>();

        for (var feed : feeds) {
            if (feed != null){
                List<SyndEntryImpl> items = feed.getEntries();
                for (var item : items) {
                    result.add(new RSSItemModel(item.getPublishedDate(),
                            item.getTitle(),
                            item.getDescription().toString(),
                            item.getUri()));
                }
            }
        }

        result.sort(null);

        if (result.size() >= 50){
            result = result.subList(0, 50);
        }

        return result;
    }
}