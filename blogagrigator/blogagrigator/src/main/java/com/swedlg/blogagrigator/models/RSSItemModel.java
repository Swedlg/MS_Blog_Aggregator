package com.swedlg.blogagrigator.models;

import java.util.Date;

public class RSSItemModel implements Comparable<RSSItemModel> {

    public Date PublishDate;

    public String Title;

    public String Description;

    public String Uri;

    public RSSItemModel(Date publishDate, String title, String description, String uri) {
        PublishDate = publishDate;
        Title = title;
        Description = description;
        Uri = uri;
    }

    @Override
    public int compareTo(RSSItemModel other) {
        return other.PublishDate.compareTo(this.PublishDate);
    }
}
