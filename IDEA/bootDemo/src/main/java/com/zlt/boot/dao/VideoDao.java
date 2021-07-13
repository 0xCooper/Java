package com.zlt.boot.dao;

import com.zlt.boot.domain.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoDao {
    //视频增加
    public List<Video> findByRid(int rid);
    public  int insert(Video video);
    public int update(Video video);
    //shanchu
    public  int delete(int id);

}
