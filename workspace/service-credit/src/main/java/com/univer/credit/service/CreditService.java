package com.univer.credit.service;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.univer.credit.mapper.CreditMapper;
import com.univer.credit.po.Credit;
import com.univer.credit.vo.CreditVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 20:02
 */
@Service
public class CreditService {

    @Autowired
    private CreditMapper creditMapper;


    /**
     * 创建课程
     * @param creditVo
     * @return
     */
    public CreditVo saveCredit(CreditVo creditVo){
        Credit credit = new Credit();
        BeanUtils.copyProperties(creditVo,credit);
        int result = creditMapper.insertSelective(credit);
        if(result == 1){
            return creditVo;
        }else {
            return null;
        }
    }

    /**
     * 更新课程
     * @param creditVo
     * @return
     */
    public Boolean updateCredit(CreditVo creditVo){
        Credit credit = new Credit();
        BeanUtils.copyProperties(creditVo,credit);
        int result = creditMapper.updateByPrimaryKeySelective(credit);
        if(result ==1 ){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查询课程详情
     * @param id
     * @return
     */
    public CreditVo detail(Long id){
        Credit credit = creditMapper.selectByPrimaryKey(id);
        CreditVo creditVo = null;
        if(credit!=null){
            creditVo = new CreditVo();
            BeanUtils.copyProperties(credit, creditVo);
        }
        return creditVo;
    }

    public List<Credit> findByPage(CreditVo creditVo){
        if(creditVo.getPage() != null && creditVo.getRows()!=null){
            PageHelper.startPage(creditVo.getPage(),creditVo.getRows());
        }
        Condition condition = new Condition(Credit.class);

        if(!StringUtils.isEmpty(creditVo.getDescription())){
            condition.createCriteria().andLike("description","%"+creditVo.getDescription()+"%");
        }
        if(creditVo.getStudentId()!=null){
            condition.createCriteria().andEqualTo("studentId",creditVo.getStudentId());
        }
        if(creditVo.getStudentName()!=null){
            condition.createCriteria().andEqualTo("studentName",creditVo.getStudentName());
        }
        condition.createCriteria().andEqualTo("status","enabled");
        return creditMapper.selectByCondition(condition);
    }
}
