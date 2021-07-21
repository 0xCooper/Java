package com.zlt.entity;

import java.io.Serializable;
import java.util.List;

public class Chapter implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6602604032930523452L;

    private String course_id; // 课程id
    private String chapter_id; // 课程章节id
    private String parent_id; // 父章节编号
    private String previous_id;// 上一章节编号
    private String resourcepath;// 资源路径
    private String linkurl; // 外链链接
    private String chaptername; // 课程名称
    private List<Chapter> child_chapter;

    // 暂定没有进行父节点、前页面的发送

    public Chapter() {}

    @Override
    public String toString() {
        return "Chapter [course_id=" + course_id + ", chapter_id=" + chapter_id + ", parent_id=" + parent_id
                + ", previous_id=" + previous_id + ", resourcepath=" + resourcepath + ", linkurl=" + linkurl
                + ", chaptername=" + chaptername + ", child_chapter=" + child_chapter + "]";
    }

    public Chapter(String course_id, String chapter_id, String parent_id, String previous_id, String resourcepath,
                   String linkurl, String chaptername, List<Chapter> child_chapter) {
        super();
        this.course_id = course_id;
        this.chapter_id = chapter_id;
        this.parent_id = parent_id;
        this.previous_id = previous_id;
        this.resourcepath = resourcepath;
        this.linkurl = linkurl;
        this.chaptername = chaptername;
        this.child_chapter = child_chapter;
    }

    public List<Chapter> getChild_chapter() {
        return child_chapter;
    }

    public void setChild_chapter(List<Chapter> child_chapter) {
        this.child_chapter = child_chapter;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getPrevious_id() {
        return previous_id;
    }

    public void setPrevious_id(String previous_id) {
        this.previous_id = previous_id;
    }

    public String getResourcepath() {
        return resourcepath;
    }

    public void setResourcepath(String resourcepath) {
        this.resourcepath = resourcepath;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

}
