package springmvcjdbc;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import db.DB;
import utils.ListPage;


@Repository
public class JdbcRepository extends DB<Region> {
	
//
//	@Autowired
//	private JdbcOperations jdbcOperations;	
//查询操作
//		public Region findOne1(long id){
//			String arg0 = "select * from region where REGION_ID=?"; 
//			if(jdbcOperations.queryForObject(arg0, new RegionMapper(),id)!=null){
//				return jdbcOperations.queryForObject(arg0, new RegionMapper(),id);
//			}
//			return null;
//		}
//		
//		public Region findOne(long id){
//			String sql = "select * from region where REGION_ID=? ";
//			List<Region> regionList = listMapToBean(jdbcOperations.queryForList(sql,id));
//			if(regionList.size()>0){
//				return regionList.get(0);
//			}
//			return null;
//		}
		public Region findOne3(long id){
			String sql = "select * from region where REGION_ID=? ";
			List<Region> regionList = queryForBeanList(sql,id);
			if(regionList.size()>0){
				return regionList.get(0);
			}
			return null;
		}
		
		public List<Region> find(){
			String sql = "select * from region";			 
			 return queryForBeanList(sql);
		}
		
		public ListPage<Region> listPage(int page,int pageSize){
			String sql = "select * from region";
			String sqlCount = "select count(0) from region";
			List<Region> params = new ArrayList<>();
			return listPage(sql, sqlCount, page, pageSize, params.toArray());
		}
	
//	//使用jdbcTemplate查询数据
//	public Region findOndByJdbcTemplate(long id){
//		String arg0 = "select * from region where REGION_ID="+id; 
//		RowMapper<Region> rowMapper = new BeanPropertyRowMapper<>(Region.class);
//		return  (Region) jdbcTemplate.query(arg0, rowMapper);
//	}
	
	//修改操作
	public  int update(Region r){
		String sql = "INSERT INTO region (REGION_ID,REGION_CODE,REGION_NAME,PARENT_ID,REGION_LEVEL,REGION_ORDER,REGION_NAME_EN,REGION_SHORTNAME_EN) VALUES (?,?,?,?,?,?,?,?)";
		return update(sql, r.getREGION_ID(),r.getREGION_CODE(),r.getREGION_NAME(),r.getPARENT_ID(),r.getREGION_LEVEL(),r.getREGION_ORDER(),r.getREGION_NAME_EN(),r.getREGION_SHORTNAME_EN());
	}
	
//	private static final class RegionMapper implements RowMapper<Region>, Serializable{
//
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//
//		@Override
//		public Region mapRow(ResultSet arg0, int arg1) throws SQLException {
//			// TODO Auto-generated method stub
//			return new Region(
//					arg0.getDouble("REGION_ID"),
//					arg0.getString("REGION_CODE"),
//					arg0.getString("REGION_NAME"),
//					arg0.getDouble("PARENT_ID"),
//					arg0.getDouble("REGION_LEVEL"),
//					arg0.getDouble("REGION_ORDER"),
//					arg0.getString("REGION_NAME_EN"),
//					arg0.getString("REGION_SHORTNAME_EN")
//					);
//		}		
//        public List<Region> extractData(ResultSet arg0) throws SQLException, DataAccessException {
//            List<Region> temps = new ArrayList<Region>();
//            while(arg0.next()){
//
//                Region r = new Region(
//    					arg0.getDouble("REGION_ID"),
//    					arg0.getString("REGION_CODE"),
//    					arg0.getString("REGION_NAME"),
//    					arg0.getDouble("PARENT_ID"),
//    					arg0.getDouble("REGION_LEVEL"),
//    					arg0.getDouble("REGION_ORDER"),
//    					arg0.getString("REGION_NAME_EN"),
//    					arg0.getString("REGION_SHORTNAME_EN")
//    					);
//                temps.add(r);
//            }
//            return temps;
//        }
//}
	
	/**
	 * 将结果map映射到指定的bean上
	 * @param cls
	 * @param list
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
//	private static  List<Region> listMapToBean( List<Map<String, Object>> list){
//		List<Region> target = new ArrayList<Region>();
//		for (Map<String, Object> t : list) {
//				Region tar = new Region();
//				ConvertUtils.register(new IntegerConverter(null), Integer.class);
//				ConvertUtils.register(new FloatConverter(null), Float.class);
//				try {
//					BeanUtils.populate(tar, t);
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				target.add(tar);
//
//		}
//		return target;
//	}
		

}
