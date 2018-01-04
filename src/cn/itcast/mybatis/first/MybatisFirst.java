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
			user.setId(109);
			user.setUsername("����ɽ12");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setAddress("�����差331222");
		// list�е�user��ӳ���ļ���resultType ��ָ��������һֱ
			sqlSession.insert("test.insertUser", user);
			
			// �ύ����
				sqlSession.commit();
			// ��ȡ�û���Ϣ����
			// mysql ����������ִ��insert�ύ֮ǰ�Զ�����һ����������
				System.out.println(user.getId());
			// �ͷ���Դ
			try {
				if(sqlSession!=null) {
					sqlSession.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	// ɾ���û���Ϣ
		@Test
		public void deleteUser() throws IOException {
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
			// ����id��ɾ���û�
				sqlSession.delete("test.deleteUser",109);
				
				// �ύ����
					sqlSession.commit();
				// ��ȡ�û���Ϣ����
				// mysql ����������ִ��insert�ύ֮ǰ�Զ�����һ����������
					
				// �ͷ���Դ
				try {
					if(sqlSession!=null) {
						sqlSession.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
	
		
		// �����û���Ϣ
				@Test
				public void updateUser() throws IOException {
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
					// list�е�user��ӳ���ļ���resultType ��ָ��������һֱ
					// �����û�����
					User user = new User();
					user.setId(105);
					user.setUsername("����");
					user.setBirthday(new Date());
					user.setSex("2");
					user.setAddress("��������");
						sqlSession.update("test.updateUser",user);
						
						// �ύ����
							sqlSession.commit();
						// ��ȡ�û���Ϣ����
						// mysql ����������ִ��insert�ύ֮ǰ�Զ�����һ����������
							
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
