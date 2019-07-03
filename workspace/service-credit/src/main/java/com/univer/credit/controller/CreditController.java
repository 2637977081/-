package com.univer.credit.controller;

import com.github.pagehelper.PageInfo;
import com.univer.base.constant.MsgConstant;
import com.univer.base.controller.AuthorizationController;
import com.univer.base.enums.StatusEnum;
import com.univer.base.util.UUIDUtil;
import com.univer.base.util.VoUtils;
import com.univer.base.vo.ResultVo;
import com.univer.credit.po.Credit;
import com.univer.credit.service.CreditService;
import com.univer.credit.vo.CreditVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author lvgang
 * @descript
 * @time 2018-12-19 19:53
 */
@RestController
@RequestMapping("/credit")
@Scope("prototype")
public class CreditController extends AuthorizationController<Object> {

    @Autowired
    private CreditVo creditVo;

    @Autowired
    private CreditService creditService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody CreditVo temp) throws Exception{
        VoUtils.copyProperties(temp, creditVo,"studentId","studentName","credit","description");
        creditVo.setCode(UUIDUtil.getUUID());
        creditVo.setCreateId(loginUser.getUserId());
        creditVo.setStatus(StatusEnum.ENABLED.toString());
        creditVo.setCreateTime(new Date());
        creditVo = creditService.saveCredit(creditVo);
        if(creditVo!=null){
            resultVo.getInstance(HttpStatus.OK.toString(),creditVo);
        }else {
            resultVo.getInstance(MsgConstant.CREATE_ERROR);
        }
        return resultVo;
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody CreditVo temp) throws Exception{
        VoUtils.copyProperties(temp, creditVo,"creditId","studentId","studentName","credit","description");
        creditVo.setUpdateTime(new Date());
        Boolean bool = creditService.updateCredit(creditVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("/delete/{id}")
    public ResultVo delete(@PathVariable Long id){
        CreditVo CreditVo = new CreditVo();
        CreditVo.setCreditId(id);
        CreditVo.setUpdateTime(new Date());
        CreditVo.setStatus(StatusEnum.DISABLED.toString());
        Boolean bool = creditService.updateCredit(CreditVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("/enable/{id}")
    public ResultVo enable(@PathVariable Long id){
        CreditVo CreditVo = new CreditVo();
        CreditVo.setCreditId(id);
        CreditVo.setUpdateTime(new Date());
        CreditVo.setStatus(StatusEnum.ENABLED.toString());
        Boolean bool = creditService.updateCredit(CreditVo);
        if(bool){
            resultVo.getInstance(HttpStatus.OK.toString(),bool);
        }else {
            resultVo.getInstance(MsgConstant.INVALID_DATA);
        }
        return resultVo;
    }

    @GetMapping("/detail/{id}")
    public ResultVo detail(@PathVariable Long id){
        CreditVo CreditVo = creditService.detail(id);
        if(CreditVo!=null){
            resultVo.getInstance(HttpStatus.OK.toString(),CreditVo);
        }else {
            resultVo.getInstance(MsgConstant.NO_DATA);
        }
        return resultVo;
    }

    @GetMapping("list")
    public ResultVo list(CreditVo temp) throws Exception {
        VoUtils.copyProperties(temp, creditVo, "creditId","studentId","studentName","credit","description", "page", "rows");
        List<Credit> list = creditService.findByPage(creditVo);
        PageInfo<Credit> pageInfo = new PageInfo<Credit>(list);
        resultVo.getInstance(HttpStatus.OK.toString(), pageInfo);
        return resultVo;
    }
}
