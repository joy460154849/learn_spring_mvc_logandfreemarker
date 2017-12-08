package db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import utils.ListPage;

public class DB<T> implements DBInterface<T>{

	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Override
	public List<T> queryForBeanList(String sql, Object... params) {
		return listMapToBean(_getEntityClass(),jdbcOperations.queryForList(sql, params));
	}

	@Override
	public List<T> queryNForBeanList(String sql, String orderbyStr, int count, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T queryForBean(String sql, Object... params) {
		List<T>  list = listMapToBean(_getEntityClass(),jdbcOperations.queryForList(sql, params));
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	

	
	
	@Override
	public T queryForBean(String sql, String orderBy, Object... params) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<>();
		return (T) jdbcOperations.queryForObject(sql, rowMapper,params);
	}

	
	/**
	 * 获取实体类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<T> _getEntityClass() {
		Class<T> entityClass = null;
		try {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityClass;
	}
	

	/**
	 * 将结果map映射到指定的bean上
	 * @param cls
	 * @param list
	 * @return
	 */
	private static <T> List<T> listMapToBean(Class<T> cls, List<Map<String, Object>> list) {
		List<T> target = new ArrayList<T>();
		for (Map<String, Object> t : list) {
			try {
				T tar = cls.newInstance();
				ConvertUtils.register(new IntegerConverter(null), Integer.class);
				ConvertUtils.register(new FloatConverter(null), Float.class);
				BeanUtils.populate(tar, t);
				target.add(tar);
			} catch (InstantiationException e) {
				throw new RuntimeException();
			} catch (IllegalAccessException e) {
				throw new RuntimeException();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return target;
	}

	@Override
	public int update(String sql, Object... params) {
		return jdbcOperations.update(sql, params);
	}

	@Override
	public ListPage<T> listPage(String sql, String sqlCount, String orderBy, int page, int pageSize, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListPage<T> listPage(String sql, String sqlCount, int page, int pageSize, Object... params) {
		List<T> items = queryForBeanList(sql, params);
		int intRowCount = queryForInt(sqlCount);
		int intPageCount = (intRowCount + pageSize - 1) / pageSize;
		ListPage<T> listPage = new ListPage<>(items, page, pageSize, intPageCount, intRowCount);
		return listPage;
	}

	@Override
	public int queryForInt(String sql, Object... params) {
		Integer i = jdbcOperations.queryForObject(sql, Integer.class, params);
		return i==null?0:i;
	}
	
}
