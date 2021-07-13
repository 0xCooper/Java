package com.zlt.boot.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.zlt.boot.dao.ResourceDao;
import com.zlt.boot.domain.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    ResourceDao resourceDao;

    //根据资源id获取该资源对应的视频数据
    @GetMapping("getAllResource")
    public List<Resource> getAllResource(){

        List<Resource> list = resourceDao.findAll();
        System.out.println(list);
        return list;

//        return list;
    }

    //视频的增加
    @GetMapping("addResource")
    public String addResource(Resource resource){
        int result = resourceDao.insert(resource);
        System.out.println(result);
        return "添加资源";
    }

    //修改
    @GetMapping("editResource")
    public String editResource(Resource resource){
        int result = resourceDao.update(resource);
        System.out.println(result);
        return "编辑资源";
    }

    //删除
    @GetMapping("delResource")
    public String delResource(int id){
        int result = resourceDao.delete(id);
        System.out.println(result);
        return "删除资源";
    }


    @GetMapping("test")
    public String test(){
        return "hello";
    }
}