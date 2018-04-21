package com.example.arkaprava.news1;

public class Article {
    private String author,title,description,time,ArticleLink;
    public Article(String author,String title,String desc,String time,String ArticleLink)
    {
        this.author=author;
        this.title=title;
        description=desc;
        this.time=time;
        this.ArticleLink=ArticleLink;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public String getArticleLink() {
        return ArticleLink;
    }
}
