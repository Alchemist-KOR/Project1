package seun;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {

	private final String NAMESPACE = "seun.myMapper";

	public List<Login_info> selectId(HashMap map) {// 아이디 찾기
		SqlSession s = getSession();
		try {
			String query=NAMESPACE+".selectId";
			List<Login_info> info= s.selectOne(query,map);
			return info;
		}finally {
			s.close();
		}
	}

	public List<Login_info> selectPwd(HashMap map) {// 비밀번호 찾기
		SqlSession s = getSession();
		try {
			String query=NAMESPACE+".selectPwd";
			List<Login_info> info = s.selectOne(query,map);
			return info;
		}finally {
			s.close();
		}
	}

	public List<Login_info> selectLogin(Login_info li) {// 로그인
		SqlSession s = getSession();
		List<Login_info> lg = null;

		try {
			String query = NAMESPACE + ".selectLogin";

			lg = s.selectList(query, li);
			return lg;
		} finally {
			s.close();
		}
	}

	public Integer insertLogin(Login_info li) {// 회원가입
		SqlSession ss = getSession();
		Integer result = null;
		try {
			String query = NAMESPACE + ".insertLogin";
			result = ss.insert(query, li);

			if (result > 0)
				ss.commit();
			else
				ss.rollback();
			return result;
		} finally {
			ss.close();
		}
	}

	private SqlSession getSession() {
		String path = "seun/mybatis_config.xml";
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession sqlSession = factory.openSession();
		return sqlSession;
	}
}
