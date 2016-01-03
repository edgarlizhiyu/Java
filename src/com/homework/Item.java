package com.homework;

/**
 * Created by zn on 2015/12/31.
 * 点播项对象每个Item都是一个点播项
 */
public class Item {
    //电影名
    private String name;
    //电影作者
    private String author;
    //电影出版日期
    private String dateOfPublication;
    //电影价格
    private int price;
    //电影内容介绍
    private String prospectus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProspectus() {
        return prospectus;
    }

    public void setProspectus(String prospectus) {
        this.prospectus = prospectus;
    }

}
