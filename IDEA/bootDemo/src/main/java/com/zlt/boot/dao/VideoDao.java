package com.zlt.boot.dao;

import com.zlt.boot.domain.Video;

import java.util.List;

public interface VideoDao {
    //视频增加
    public List<Video> findByRid(int rid);
    public  int insert(Video video);
    public int update(Video video);
    //shanchu
    public  int delete(int id);

}
