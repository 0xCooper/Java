package com.zlt.boot.domain;

public class Resource {

    private int id;
    private String resourceName;
    private  String resourceImg;
    private  int studyNum;
    private  int price;

    public Resource() {
    }

    public Resource(int id, String resourceName, String resourceImg, int studyNum, int price) {
        this.id = id;
        this.resourceName = resourceName;
        this.resourceImg = resourceImg;
        this.studyNum = studyNum;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceImg() {
        return resourceImg;
    }

    public void setResourceImg(String resourceImg) {
        this.resourceImg = resourceImg;
    }

    public int getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(int studyNum) {
        this.studyNum = studyNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
