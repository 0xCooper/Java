package com.zlt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
	public boolean userLogin(@Param("sname") String name);
	public List<String> getCourseByUserId(@Param("user_id") String user_id);
}
