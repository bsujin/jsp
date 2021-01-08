package kr.or.ddit.db;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtill {

	// 싱글톤 만들기

	// getSqlSession() 에서 사용하기 위에 선언해준다
	static SqlSessionFactory sqlSessionFactory;

	// calss 로딩시 자동으로 실행되는 static 블록
	static {

		try {
			String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// SqlSessionFactory.openSession()에서 제공해주는 sqlSession 을 dao객체에서 얻어가려고 한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 원하는 객체에 제공해준다 - sqlSessionFactory를 쓰려고 하는데 접근이 안되어 에러 -> 선언부를 밖으로 빼준다
	// static을 해줘야한다 - 외부에 객체 없이 실행 가능하도록 하기위함 
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
