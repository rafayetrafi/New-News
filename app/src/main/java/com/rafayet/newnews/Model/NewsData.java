package com.rafayet.newnews.Model;

import java.util.ArrayList;

public class NewsData {

    private String status;
    private String totalResults;
    private ArrayList<NewsDetailsModel> articles;

    public NewsData(String status, String totalResults, ArrayList<NewsDetailsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsDetailsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsDetailsModel> articles) {
        this.articles = articles;
    }
}
