package com.swedlg.blogagrigator.models.controllers;

import com.swedlg.blogagrigator.logics.RSS_Parser;
import com.swedlg.blogagrigator.storage.UrlsStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final UrlsStorage urlsStorage = new UrlsStorage(new String[] {});

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Выбор источников");
        return "index";
    }

    @GetMapping("/newest_blogs/")
    public String newest_blogs(Model model) {
        RSS_Parser rss_parser = new RSS_Parser(urlsStorage.getUrls());
        model.addAttribute("title", "Блоги");
        model.addAttribute("dates", rss_parser.GetItemsRSSFeed());
        return "newest_blogs";
    }

    @PostMapping("/")
    public String blockPostAdd(@RequestParam String urls, Model model) {
        if (urls.length() == 0){
            return "index";
        }

        urlsStorage.setUrls(urls.split("[\n\r\s]+"));

        return "redirect:/newest_blogs/";
    }
}
