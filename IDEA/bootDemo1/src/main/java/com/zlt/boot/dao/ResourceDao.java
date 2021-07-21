package com.zlt.boot.dao;

import com.zlt.boot.domain.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceDao {
    // 查询学习资源表的接口
    public List<Resource> findAll();

    //学习资源的增加
    public  int insert(Resource resource);

    //删除
    public int delete(int rid);

    //修改
    public int update(Resource resource);
}
