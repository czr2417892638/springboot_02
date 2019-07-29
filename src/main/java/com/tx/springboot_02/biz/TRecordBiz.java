package com.tx.springboot_02.biz;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.springboot_02.dao.TRecordDAO;
import com.tx.springboot_02.pojo.TRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class TRecordBiz {
    @Autowired
    private TRecordDAO rdao;

    public PageInfo<TRecord> findAll(int num , int size, String des, String name){
        PageHelper.startPage(num,size);
        return new PageInfo<TRecord>(rdao.findAll(des,name));
    }

    public int deleteByPrimaryKey(int id){
        return rdao.deleteByPrimaryKey(id);
    }

    public  int insertSelective(TRecord record){
        return rdao.insertSelective(record);
    }

    public TRecord selectByPrimaryKey(Integer id)
    {
        return rdao.selectByPrimaryKey(id);
    }
    public int  updateByPrimaryKeySelective(TRecord record){
        return rdao.updateByPrimaryKeySelective(record);
    }

    public List<TRecord> findTRecord(String stucode){
        return rdao.findTRecord(stucode);
    }
}
