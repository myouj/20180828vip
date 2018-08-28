package com.ma.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
 * @ClassName: BaseDao 
 * @Description: TODO 作为Dao的父接口，定义一些基本的增删改查
 * @author: youj
 * @date: 2018年8月20日 下午8:05:27 
 * @param <T> 
 */
public interface BaseDao<T> {
	
	void insert(T t) throws Exception;
	
	void delete(@Param("key") String ukfeild, @Param("value")Object value) throws Exception;
	
	void update(T t) throws Exception;
	
	T select(@Param("key") String ukfeild, @Param("value") Object value) throws Exception;
	boolean isExists(@Param("key") String ukfeild, @Param("value") Object value) throws Exception;
	List<T> selectLike(@Param("key") String key) throws Exception;

}
