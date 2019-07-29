package com.tx.springboot_02.dao;

import com.tx.springboot_02.pojo.TRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TRecordDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(TRecord record);

    int insertSelective(TRecord record);

    TRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TRecord record);

    int updateByPrimaryKey(TRecord record);

    List<TRecord> findAll(@Param("des") String des, @Param("name") String name);
    List<TRecord> findTRecord(@Param("stucode") String stucode);
}