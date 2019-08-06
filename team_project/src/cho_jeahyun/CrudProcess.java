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
	
	
	public List<Manager_info> select_managerLogin(Manager_info li) {//������ �α���
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
	public List<Login_info> selectLogin(Login_info li) {//�α���
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
	public List<Login_info> selectCustomer(HashMap map) {//�����ڰ� Ư�� ȸ�� �˻�
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
	public List<Login_info> selectAllCustomer() {//�����ڰ� ��� ȸ�� �˻�
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
	public List<Login_info> selectAccount(String cid) {//���������� ��ȸ
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
	
	public String selectId(Login_info lg) {//���̵� ã��
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
	public String selectPw(Login_info lg) {//��й�ȣ ã��
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

	public Integer insertLogin(Login_info li) {//ȸ������
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
	public List<Reservation_Info> selectAllReservation_Info(String cid) {//ȸ�� ���೻��Ȯ��
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
	public List<Reservation_Info> selectAllReservation_Info_non(Reservation_Info info) {//��ȸ�� ���೻��Ȯ��
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
	public List<Reservation_Info> selectReservation(HashMap map) {// �����ڰ� Ư�� ���೻�� �˻�
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
	public List<Reservation_Info> selectAllReservation() {// �����ڰ� ��� ���� ���� Ȯ��
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
	public List<Check_inout> selectAllCheckInout() {// üũ��/�ƿ� ���̺� �˻�
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
	public List<Check_inout> selectCheck_inout(Check_inout info) {//�����ڰ� Ư�� ���೻��Ȯ��
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
	public Integer check_in_true(Check_inout cio) {// ���̺� üũ�� ��¥ �Է�
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
	public Integer check_out_true(Check_inout cio) {// ���̺� üũ�ƿ� ��¥ �Է�
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

	public Integer updateCustomer(Login_info info) {// �� �������� ���� ����
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
	public int deleteCustomer(HashMap map) {// ȸ�� Ż��
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
















