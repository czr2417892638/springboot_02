package com.tx.springboot_02.dao;

import com.tx.springboot_02.pojo.TStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TStudentDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    TStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);

    /**
     * 登录
     */
    TStudent login(@Param("name")String name,@Param("code")String code);

    List<TStudent> findAll();
}