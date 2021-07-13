package com.zlt.boot.domain;

public class Video {
    private  int id;
    private String videoName;
    private String uploadDate;
    private int studyNmu;
    private int resourceId;

    public Video(int id, String videoName, String uploadDate, int studyNmu, int resourceId) {
        this.id = id;
        this.videoName = videoName;
        this.uploadDate = uploadDate;
        this.studyNmu = studyNmu;
        this.resourceId = resourceId;
    }

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

    public int getStudyNmu() {
        return studyNmu;
    }

    public void setStudyNmu(int studyNmu) {
        this.studyNmu = studyNmu;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
