package com.zlt.boot.controller;

import com.zlt.boot.dao.ResourceDao;

import com.zlt.boot.dao.VideoDao;
import com.zlt.boot.domain.Resource;
import com.zlt.boot.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class VideoController {

    @Autowired
    VideoDao videoDao;

    @GetMapping("getVideo")
    public List<Video> getVideo(int id){
        List<Video> list = videoDao.findByRid(id);
        System.out.println(list);
        return list;
    }
    @GetMapping("addVideo")
    public String addVideo(Video video){
        int result = videoDao.insert(video);
        System.out.println(result);
        return "添加视频";

    }
    @GetMapping("editVideo")
    public String editVideo(Video video){
        int result = videoDao.update(video);
        System.out.println(result);
        return "修改视频";

    }
    @GetMapping("delVideo")
    public String delVideo(int id){
        int result = videoDao.delete(id);
        System.out.println(result);
        return "删除视频";

    }
    @GetMapping("getVideoByName")
    public List<Video> getVideoByName(String name){
        System.out.println("参数"+name);
        List<Video> list=videoDao.findByName(name);
        return list;
    }


}
