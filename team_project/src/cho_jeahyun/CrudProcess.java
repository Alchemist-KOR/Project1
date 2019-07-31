package cho_jeahyun;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class CrudProcess {

	private final String NAMESPACE="cho_jeahyun.myMapper";
	public List<Login_info> selectLogin(Login_info li) {//로그인
		SqlSession s = getSession();
		List<Login_info> lg = null;
		
		try {
			String query=NAMESPACE+".selectLogin";

			lg = s.selectList(query,li);
			return lg;
		}finally {
			s.close();
		}
	}

	public Integer insertLogin(Login_info li) {//회원가입
		SqlSession ss=getSession();
		Integer result=null;
		try {
			String query=NAMESPACE+".insertLogin";
			result=ss.insert(query,li);
			
			if(result>0) ss.commit();
			else ss.rollback();		
			return result;
		}finally {
			ss.close();
		}
	}
	public List<Reservation_Info> selectAllReservation_Info() {
		SqlSession s = getSession();
		List<Reservation_Info> info = null;
		
		try {
			String query = NAMESPACE + ".selectAllReservation_Info";
			info = s.selectList(query);
			
			return info;
		}finally {
			s.close();
		}
		
	}
	public List<Reservation_Info> selectIteminfo(HashMap map) {
		SqlSession s = getSession();
		List<Reservation_Info> info = null;
		
		try {
			String query = NAMESPACE + ".selectItem";
			info = s.selectList(query, map);
			
			return info;
		}finally {
			s.close();
		}
		
	}
	public Integer insertItemInfo(Reservation_Info info) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String query = NAMESPACE+".insertItemInfo";
			result = session.insert(query, info);
			if(result > 0) {
				session.commit();
			}else {
				session.close();
			}
		return result;
		}finally {
			session.close();
		}
	}
	public Integer updateItemInfo(Reservation_Info info) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String query = NAMESPACE+".updateItemInfo";
			result = session.insert(query, info);
			if(result > 0) {
				session.commit();
			}else {
				session.rollback();
			}return result;
		}finally {
			session.close();
		}
	}
	public int deleteIteminfoCondition(HashMap map) {
		SqlSession s = getSession();
		int result = 0;
		try {
			String query = NAMESPACE + ".deleteItemInfo";
			result = s.delete(query,map);
			if(result > 0) {
				s.commit();
			}else {
				s.rollback();
			}return result;
		}finally {
			s.close();
		}
	}
	private SqlSession getSession(){
		String path = "cho_jeahyun/mybatis_config.xml";
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
















