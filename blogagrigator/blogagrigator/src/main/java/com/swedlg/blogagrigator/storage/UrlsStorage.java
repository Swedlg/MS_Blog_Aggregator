package com.swedlg.blogagrigator.storage;

public class UrlsStorage {

    private String[] urls;

    public UrlsStorage(String[] urls) {
        this.urls = urls;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }
}
