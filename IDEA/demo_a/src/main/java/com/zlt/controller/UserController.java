package com.zlt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zlt.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zlt.dao.GetCourseDao;
import com.zlt.dao.LoginDao;
import com.zlt.dao.UserDao;
import com.zlt.entity.User;
import com.zlt.entity.Course;
import com.zlt.entity.TreeService;

import io.swagger.annotations.Api;

@Controller
@Api(value = "查询业务类")
public class UserController {

    @Autowired
    private UserDao userdao;
    @Autowired
    private LoginDao logindao;
    @Autowired
    private GetCourseDao getCoursedao;
    ;

    @RequestMapping(value = "user/getCourse")
    @ResponseBody
    public void getCourseByUser(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        HttpSession session = request.getSession();
        String user_id = request.getParameter("user_id");

        Object userinfo = session.getAttribute("userInfo");
        Map<String, Object> map = new HashMap<>();

        System.out.println("user_id" + user_id);
        System.out.println("userinfo" + userinfo);
//        user_id.toString().equals(userinfo)
        if (true) { //登录信息一致
            List<String> course_id_ary = userdao.getCourseByUserId(user_id);
            List<Course> course_ary = new ArrayList<>();
            Course temp_course;
            //向List中添加课程信息
            for (int i = 0; i < course_id_ary.size(); i++) {

                temp_course = getCoursedao.getCourseMoreByCourseId(course_id_ary.get(i));
                if (temp_course == null) {
                    System.out.println("error");
                    continue;
                } else {
                    System.out.println(temp_course.toString());
                    course_ary.add(temp_course);
                    System.out.println("add finish");
                }

            }

            map.put("code", 100);
            map.put("msg", "ok");
            if (course_ary.size() == 0) {
                map.put("data", null);

            } else {
                map.put("data", course_ary);
            }
        } else {
            map.put("code", 103);
            map.put("msg", "登录状态不正确");
            map.put("data", null);
        }

        //数据转json
        ObjectMapper om = new ObjectMapper();
        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));
    }

    @RequestMapping(value = "user/getCourseInfo")
    @ResponseBody
    public void getCourseInfoByCourse(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        HttpSession session = request.getSession();
        Object userinfo = session.getAttribute("userInfo");

        Map<String, Object> map = new HashMap<>();

        if (userinfo == null) {
            map.put("code", 103);
            map.put("msg", "登录状态不正确");
            map.put("data", null);

        } else {
            String course_id = request.getParameter("course_id");
            Course course_info = getCoursedao.getCourseMoreByCourseId(course_id);
            if (course_info == null) {
                map.put("code", 101);
                map.put("msg", "no");
                map.put("data", null);
            } else {
                map.put("code", 100);
                map.put("msg", "ok");
                map.put("data", course_info);
            }
        }

        //数据转json
        ObjectMapper om = new ObjectMapper();
        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));
    }


    @RequestMapping(value = "user/getChapter")
    @ResponseBody
    public void getChapterByCourseId(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        HttpSession session = request.getSession();
        Object userinfo = session.getAttribute("userInfo");
        Map<String, Object> map = new HashMap<>();

        if (userinfo == null) {
            map.put("code", 103);
            map.put("msg", "登录状态不正确");
            map.put("data", null);
        } else {
            String course_id = request.getParameter("course_id");
            Course course_info = getCoursedao.getCourseMoreByCourseId(course_id);
            List<Chapter> chapter_ary = getCoursedao.getChapterByCourseId(course_id);

            TreeService chaTreeService = new TreeService(chapter_ary);
            List<Chapter> CharTree = chaTreeService.buildTree();
            List<Chapter> CharResult = null;

            if (CharTree == null) {
                map.put("code", 101);
                map.put("msg", "no");
                map.put("data", null);
            } else {
                map.put("code", 100);
                map.put("msg", "ok");
                map.put("course_data", course_info);
                map.put("chapter_data", CharTree);
            }
        }

        //数据转json
        ObjectMapper om = new ObjectMapper();
        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));
    }

    @RequestMapping(value = "user/getVideoChapter")
    @ResponseBody
    public void getVideoByChapterId(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, IOException {
        HttpSession session = request.getSession();
        Object userinfo = session.getAttribute("userInfo");
        Map<String, Object> map = new HashMap<>();

        if (userinfo == null) {
            map.put("code", 103);
            map.put("msg", "登录状态不正确");
            map.put("data", null);
        } else {
            String chapter_id = request.getParameter("chapter_id");
            String video_link = getCoursedao.getVideoByChapterId(chapter_id);

            if (video_link == null) {
                map.put("code", 101);
                map.put("msg", "no");
                map.put("data", null);
            } else {
                map.put("code", 100);
                map.put("msg", "ok");
                map.put("data", null);
                map.put("urllink", video_link);
            }
        }

        //数据转json
        ObjectMapper om = new ObjectMapper();
        //跨域头
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
        response.setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
        response.setHeader("XDomainRequestAllowed", "1");
        //返回的数据作为json
        response.setHeader("Content-Type", "application/json");
        response.getWriter().write(om.writeValueAsString(map));
    }

}
