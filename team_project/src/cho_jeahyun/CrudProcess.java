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
	public List<Login_info> selectAccount(String cid) {//마이페이지 조회
		SqlSession s = getSession();
		List<Login_info> lg = null;
		
		try {
			String query=NAMESPACE+".selectAccount";

			lg = s.selectList(query,cid);
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
	public List<Reservation_Info> selectAllReservation_Info(String cid) {//회원 예약내역확인
		SqlSession s = getSession();
		List<Reservation_Info> info = null;
		
		try {

			String query = NAMESPACE + ".selectAllReservation_Info";
			info = s.selectList(query,cid);
			
			return info;
		}finally {
			s.close();
		}
		
	}

	public Integer updateCustomer(Login_info info) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String query = NAMESPACE+".updateCustomer";
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
	public int deleteCustomer(HashMap map) {
		SqlSession s = getSession();
		int result = 0;
		try {
			String query = NAMESPACE + ".deleteCustomer";
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
















