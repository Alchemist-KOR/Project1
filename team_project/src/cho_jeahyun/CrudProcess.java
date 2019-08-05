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
	
	
	public List<Manager_info> select_managerLogin(Manager_info li) {//관리자 로그인
		SqlSession s = getSession();
		List<Manager_info> lg = null;
		
		try {
			String query=NAMESPACE+".select_managerLogin";

			lg = s.selectList(query,li);
			return lg;
		}finally {
			s.close();
		}
	}
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
	public List<Login_info> selectCustomer(HashMap map) {//관리자가 특정 회원 검색
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
	public List<Login_info> selectAllCustomer() {//관리자가 모든 회원 검색
		SqlSession s = getSession();
		List<Login_info> lg = null;
		
		try {
			String query=NAMESPACE+".selectAllCustomer";

			lg = s.selectList(query);
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
	
	public String selectId(Login_info lg) {//아이디 찾기
		SqlSession s = getSession();
		String id = null;
		
		try {
			String query=NAMESPACE+".selectId";

			id = s.selectOne(query,lg);

			return id;
		}finally {
			s.close();
		}
	}
	public String selectPw(Login_info lg) {//비밀번호 찾기
		SqlSession s = getSession();
		String pw = null;
		
		try {
			String query=NAMESPACE+".selectPw";

			pw = s.selectOne(query,lg);

			return pw;
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
	public List<Reservation_Info> selectAllReservation_Info_non(Reservation_Info info) {//비회원 예약내역확인
		SqlSession s = getSession();
		List<Reservation_Info> res = null;
		
		try {

			String query = NAMESPACE + ".selectAllReservation_Info_non";
	
			res = s.selectList(query,info);
			
			return res;
		}finally {
			s.close();
		}
	}
	public List<Reservation_Info> selectReservation(HashMap map) {// 관리자가 특정 예약내역 검색
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
	public List<Reservation_Info> selectAllReservation() {// 관리자가 모든 예약 내역 확인
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
	public List<Check_inout> selectAllCheckInout() {// 체크인/아웃 테이블 검색
		SqlSession s = getSession();
		List<Check_inout> info = null;
		
		try {
			String query = NAMESPACE + ".selectAllCheck_inout";
			info = s.selectList(query);
			
			Iterator it = info.iterator();
			while(it.hasNext()) {
				Check_inout ck = (Check_inout) it.next();
			}
			
			return info;
		}finally {
			s.close();
		}
		
	}
	public List<Check_inout> selectCheck_inout(Check_inout info) {//관리자가 특정 예약내역확인
		SqlSession s = getSession();
		List<Check_inout> res = null;
		
		try {

			String query = NAMESPACE + ".selectCheck_inout";
	
			res = s.selectList(query,info);
			
			return res;
		}finally {
			s.close();
		}
	}
	public Integer check_in_true(Check_inout cio) {// 테이블에 체크인 날짜 입력
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
	public Integer check_out_true(Check_inout cio) {// 테이블에 체크아웃 날짜 입력
		SqlSession ss = getSession();
		Integer result = null;
		try {
			String query=NAMESPACE+".Check_out_t";
			result=ss.insert(query, cio);
			if(result > 0) ss.commit();
			else ss.rollback();
			return result;
		}finally {
			ss.close();
		}
	}

	public Integer updateCustomer(Login_info info) {// 고객 가입정보 고객이 수정
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
	public int deleteCustomer(HashMap map) {// 회원 탈퇴
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
















