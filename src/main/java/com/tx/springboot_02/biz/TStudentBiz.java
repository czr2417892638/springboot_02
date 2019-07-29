package com.tx.springboot_02.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tx.springboot_02.dao.TStudentDAO;
import com.tx.springboot_02.pojo.TStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class TStudentBiz {
    @Autowired
    private TStudentDAO sdao;
    public TStudent login(String name,String code){
        return  sdao.login(name,code);
    }

    /**
     * 查询全部
     * @param num
     * @param size
     * @return
     */
    public PageInfo<TStudent> findAll(int num,int size){
        PageHelper.startPage(num,size);
        return  new PageInfo<TStudent>(sdao.findAll());
    }
}
