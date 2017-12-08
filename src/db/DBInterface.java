package db;

import java.util.List;

import utils.ListPage;


public interface DBInterface<T> {
	
	
	 /**
     * 查询返回分页列表(Bean)
     * 
     * @param sql
     * @param sqlCount
     * @param page
     * @param pageSize
     * @param params
     * @return
     */
    public abstract ListPage<T> listPage(String sql, String sqlCount, String orderBy, int page, int pageSize,
            Object... params);

    public abstract ListPage<T> listPage(String sql, String sqlCount, int page, int pageSize, Object... params);
	 /**
     * 查询返回列表(Bean)
     * 
     * @param sql
     * @param params
     * @return
     */
    public abstract List<T> queryForBeanList(String sql, Object... params);

    /**
     * 查询返回列表N(Bean)
     * 
     * @param sql
     * @param count
     * @param params
     * @return
     */
    public abstract List<T> queryNForBeanList(String sql, String orderbyStr, int count, Object... params);

    /**
     * 查询返回一个Bean
     * 
     * @param sql
     * @param params
     * @return
     */
    public abstract T queryForBean(String sql, String orderBy, Object... params);

    public abstract T queryForBean(String sql, Object... params);
    
    public abstract int update(String sql, Object... params);
    
    public abstract int queryForInt(String sql, Object... params);
}
