package com.zlt.boot.domain;

public class Video {
    private  int id;
    private String videoName;
    private String uploadDate;
    private int studyNum;
    private int resourceId;
    private  String videoUrl;

    public Video(int id, String videoName, String uploadDate, int studyNum, int resourceId, String videoUrl) {
        this.id = id;
        this.videoName = videoName;
        this.uploadDate = uploadDate;
        this.studyNum = studyNum;
        this.resourceId = resourceId;
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

//    public Video(int id, String videoName, String uploadDate, int studyNum, int resourceId) {
//        this.id = id;
//        this.videoName = videoName;
//        this.uploadDate = uploadDate;
//        this.studyNum = studyNum;
//        this.resourceId = resourceId;
//    }

    public Video() {
    }

    public int getId() {
        return id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getStudyNum() {
        return studyNum;
    }

    public void setStudyNum(int studyNum) {
        this.studyNum = studyNum;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
