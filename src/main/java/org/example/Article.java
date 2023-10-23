package org.example;

public class Article {
    int id;
    String title;
    String content;
    public Article(int registedNumber, String title, String content) {
        this.id = registedNumber;
        this.title = title;
        this.content = content;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;

    }
    public String getContent(){
        return this.content;
    }

    public void setTitle(String settitle){
        this.title = settitle;
    }
    public void setContent(String setcontent){
        this.content = setcontent;
    }
}
