package cyc_real;


import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class CrudProcess {

	private final String NAMESPACE="cyc.myMapper";
	
	
	public List selectSalesAvg(Sales_management_M sm) {
		SqlSession s = getSession();
		List info = null;
		
		try {
			String query = NAMESPACE + ".selectSalesAvg";
			info = s.selectList(query , sm);
			
			return info;
		}finally {
			s.close();
		}
		
	}
	
	public List selectSalesSum(Sales_management_M sm) {
		SqlSession s = getSession();
		List info = null;
		
		try {
			String query = NAMESPACE + ".selectSalesSum";
			info = s.selectList(query , sm);
			
			return info;
		}finally {
			s.close();
		}
		
	}
	public List<Check_inout> selectAllCheckInout() {
		SqlSession s = getSession();
		List<Check_inout> info = null;
		
		try {
			String query = NAMESPACE + ".selectAllCheck_inout";
			info = s.selectList(query);
			
			return info;
		}finally {
			s.close();
		}
		
	}
	public Integer check_in_true(Check_inout cio) {
		SqlSession ss = getSession();
		Integer result = null;
		try {
			String query=NAMESPACE+".Check_in_t";
			result=ss.insert(query, cio);
			if(result > 0) ss.commit();
			else ss.rollback();
			return result;
		}finally {
			ss.close();
		}
	}

	public Integer check_out_true(Check_inout cio) {
		SqlSession ss = getSession();
		Integer result = null;
		try {
			String query =NAMESPACE+".Check_out_t";
			result = ss.update(query, cio);
			if(result > 0) ss.commit();
			else ss.rollback();
			return result;
		}finally{
			ss.close();
		}
	}
	
	public List<Reservation_Info> selectReservation(HashMap map) {//로그인
		SqlSession s = getSession();
		List<Reservation_Info> info = null;
		
		try {
			String query=NAMESPACE+".selectReservation";
			List<Reservation_Info> data = s.selectList(query, map);
			return data;
		}finally {
			s.close();
		}
	}
	public List<Reservation_Info> selectAllReservation() {
		SqlSession s = getSession();
		List<Reservation_Info> info = null;
		
		try {
			String query = NAMESPACE + ".selectAllReservation";
			info = s.selectList(query);
			
			return info;
		}finally {
			s.close();
		}
		
	}

	
	
	
	
	public List<Login_info> selectCustomer(HashMap map) {//로그인
		SqlSession s = getSession();
		List<Login_info> lg = null;
		
		try {
			String query=NAMESPACE+".selectCustomer";
			List<Login_info> data = s.selectList(query, map);
			return data;
		}finally {
			s.close();
		}
	}


	public List<Login_info> selectAllCustomer() {
		SqlSession s = getSession();
		List<Login_info> info = null;
		
		try {
			String query = NAMESPACE + ".selectAllCustomer";
			info = s.selectList(query);
			
			return info;
		}finally {
			s.close();
		}
		
	}


	private SqlSession getSession(){
		String path = "cyc/mybatis_config.xml";
		InputStream is = null;
		try {
			is=Resources.getResourceAsStream(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory=builder.build(is);
		SqlSession sqlSession=factory.openSession();
		return sqlSession;
	}
}
















