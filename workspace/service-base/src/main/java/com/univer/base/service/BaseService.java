package com.univer.base.service;

import com.univer.base.mapper.BaseMapper;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author guwei
 *
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class BaseService<T> {

	@Autowired
	protected MessageSource messageSource;

	@Autowired
	protected BaseMapper<T> mapper;

	/**当前泛型真实类型的Class*/
	private Class<T> modelClass;

	@SuppressWarnings("unchecked")
	public BaseService() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		modelClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public int save(T model) {
		return mapper.insertSelective(model);
	}

	public int save(List<T> models) {
		return mapper.insertList(models);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int deleteByIds(String ids) {
		return mapper.deleteByIds(ids);
	}

	public int update(T model) {
		return mapper.updateByPrimaryKeySelective(model);
	}

	public T findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public T findBy(String fieldName, Object value) throws TooManyResultsException {
		try {
			T model = modelClass.newInstance();
			Field field = modelClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(model, value);
			return mapper.selectOne(model);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException("查询操作异常!");
		}
	}

	public List<T> findByIds(String ids) {
		return mapper.selectByIds(ids);
	}

	public List<T> findByCondition(Condition condition) {
		return mapper.selectByCondition(condition);
	}

	public List<T> findAll() {
		return mapper.selectAll();
	}

}
