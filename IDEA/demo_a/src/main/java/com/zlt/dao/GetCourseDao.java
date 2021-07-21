package com.zlt.dao;

import java.util.List;
import com.zlt.entity.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zlt.entity.Course;

@Mapper
public interface GetCourseDao {
	public Course getCourseMoreByCourseId(@Param("course_id") String course_id);//通过课程id获取
	public List<Chapter> getChapterByCourseId(@Param("course_id") String course_id);//通过课程id查询章节信息
	public String getVideoByChapterId(@Param("chapter_id") String chapter_id);//通过章节id查询url
}
