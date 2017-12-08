package db;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class RowMappers<T> implements RowMapper<T>{
	
	/**
	 * 获取实体类
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		Class<T> entityClass = null;
		try {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityClass;
	}

	@Override
	public T mapRow(ResultSet arg0, int arg1) throws SQLException {
		List<T> list = resultSetToList(arg0);
		return null;
	}
	
	public  List<T> resultSetToList(ResultSet rs) throws java.sql.SQLException {   
	           if (rs == null)   
	               return null;  
	           ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
	           int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
	           List<T> list = new ArrayList<>();   
	           Map<String,Object> rowData = new HashMap<>();   
	           while (rs.next()) {   
	            rowData = new HashMap<>(columnCount);   
	            for (int i = 1; i <= columnCount; i++) {   
	                    rowData.put(md.getColumnName(i), rs.getObject(i));   
	            }   
	            try {
					org.apache.commons.beanutils.BeanUtils.populate(getEntityClass(), rowData);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	            System.out.println("list:" + list.toString()); 
	            
//	            list.add(rowData);  
	           }   
	           return list;   
	   } 

}
