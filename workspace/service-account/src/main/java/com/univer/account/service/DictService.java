package com.univer.account.service;

import com.github.pagehelper.PageHelper;
import com.univer.account.mapper.DictMapper;
import com.univer.account.po.Dict;
import com.univer.account.vo.DictVo;
import com.univer.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guwei on 2018/09/10.
 * @author hongjiao
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DictService extends BaseService<Dict> {

	private static final Logger log = LoggerFactory.getLogger(DictService.class);

	@Autowired
	private DictMapper dictMapper;

	/**
	 * 分页查询
	 */
	public List<DictVo> findByPage(DictVo dictVo) {
		if (dictVo.getPage() != null && dictVo.getRows() != null) {
			PageHelper.startPage(dictVo.getPage(), dictVo.getRows());
		}
		return null;
	}

	/**
	 * 按类型查询
	 */
	public List<Dict> findDictByType(String type){
		Condition condition = new Condition(Dict.class);
		Condition.Criteria criteria = condition.createCriteria();
		criteria.andEqualTo("type", type);
		return dictMapper.selectByCondition(condition);
	}

	/**
	 * 按类型查询返回hashMap
	 */
	public Map<String,String> findMapByType(String type){
		List<DictVo> list = dictMapper.findMapByType(type);
		Map<String,String> map = new HashMap<>(16);
		for (DictVo dictVo:list){
			map.put(dictVo.getName(),dictVo.getValue());
		}
		return map;
	}

	/**
	 * 查询用户信息
	 */
	public DictVo findDictById(Long id) {
		DictVo dictVo = null;
		Dict dict = dictMapper.selectByPrimaryKey(id);
		if(dict != null) {
            dictVo = new DictVo();
            BeanUtils.copyProperties(dict, dictVo);
        }
		return dictVo;
	}

	/**
	 * 创建
	 */
	public DictVo saveDict(DictVo dictVo) {
		Dict dict = new Dict();
		BeanUtils.copyProperties(dictVo, dict);
        dictVo = null;
		int result = dictMapper.insertSelective(dict);
		if(result == 1) {
            dictVo = findDictById(dict.getDictId());
        }
        return dictVo;
	}

    /**
     * 更新
     */
    public DictVo updateDict(DictVo dictVo) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictVo, dict);
        dictVo = null;
        int result = dictMapper.updateByPrimaryKeySelective(dict);
        if(result == 1) {
            dictVo = findDictById(dict.getDictId());
        }
        return dictVo;
    }

}
