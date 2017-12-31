package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 * ���ų���
 * @author Administrator
 *
 */
public class MybatisFirst {
	// ����id ��ѯ�û���Ϣ���õ�һ����¼ �Ľ��
//	public static final void main(String[] args) throws IOException {
//		findUsrByIdTest();
//	}
//	@Test
	public void findUsrByIdTest() throws IOException {
		// mybatis �����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession= sqlSessionFactory.openSession();
		
		//ͨ��SqlSession �������ݿ�
		// ��һ��������ӳ���ļ���statement��id,����=namespace+ "." + statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ�� ��parameterType ���͵Ĳ���
		//sqlSession.selectOne �������ӳ���ļ���ƥ���resultType���͵Ķ���
		
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		// �ͷ���Դ
		try {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// �����û�����ģ����ѯ�û��б�
//	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis �����ļ�
				String resource = "SqlMapConfig.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				// �����Ự����
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// ͨ�������õ�SqlSession
				SqlSession sqlSession= sqlSessionFactory.openSession();
				
				//ͨ��SqlSession �������ݿ�
				// ��һ��������ӳ���ļ���statement��id,����=namespace+ "." + statement��id
				// �ڶ���������ָ����ӳ���ļ�����ƥ�� ��parameterType ���͵Ĳ���
				//sqlSession.selectOne �������ӳ���ļ���ƥ���resultType���͵Ķ���
				// list �е�userh��ӳ���ļ��е�resultTye�е�����ʱ��ͬ��
			List<User> list = sqlSession.selectList("test.findUserByName","%С��%");
			
			System.out.println(list);
			
			// �ͷ���Դ
			try {
				if(sqlSession!=null) {
					sqlSession.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	// ����û���Ϣ
	@Test
	public void insertUserTest() throws IOException {
		// mybatis �����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession= sqlSessionFactory.openSession();
		
		//ͨ��SqlSession �������ݿ�
		// ��һ��������ӳ���ļ���statement��id,����=namespace+ "." + statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ�� ��parameterType ���͵Ĳ���
		//sqlSession.selectOne �������ӳ���ļ���ƥ���resultType���͵Ķ���
		// list �е�userh��ӳ���ļ��е�resultTye�е�����ʱ��ͬ��
		// �����û�����
			User user = new User();
			user.setId(102);
			user.setUsername("����1");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setAddress("����֣��331");
		// list�е�user��ӳ���ļ���resultType ��ָ��������һֱ
			sqlSession.insert("test.insertUser", user);
		
			// �ύ����
				sqlSession.commit();
			
			// �ͷ���Դ
			try {
				if(sqlSession!=null) {
					sqlSession.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
}
