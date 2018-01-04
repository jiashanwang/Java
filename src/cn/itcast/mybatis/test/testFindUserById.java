package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class testFindUserById {
	public static final void main(String[] args) {
		try {
//			test();
//			testList();
//			findList();
//			findUserCount();
			testListMap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ����id ����ѯ������¼ 
	public static void test() throws IOException {
		// mybatis �����ļ�
				String resource = "SqlMapConfig.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				// �����Ự����
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// ͨ�������õ�SqlSession
				SqlSession sqlSession= sqlSessionFactory.openSession();
		// ����UserMapper����
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// ����userMapper�ķ���
				
				try {
					User user = userMapper.findUserById(105);
					sqlSession.close();
					System.out.println(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	// ���һ��resultMap
	// ����name����ѯ�����¼
		public static void testListMap() throws IOException {
			// mybatis �����ļ�
					String resource = "SqlMapConfig.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					// �����Ự����
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					// ͨ�������õ�SqlSession
					SqlSession sqlSession= sqlSessionFactory.openSession();
			// ����UserMapper����
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				// ����userMapper�ķ���
					try {
						User user = userMapper.findUserByIdResultMap(36);
						sqlSession.close();
						System.out.println(user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		@Test
		// �û���Ϣ���ۺϲ�ѯ
		public void findList() throws IOException {
			// mybatis �����ļ�
					String resource = "SqlMapConfig.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					// �����Ự����
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					// ͨ�������õ�SqlSession
					SqlSession sqlSession= sqlSessionFactory.openSession();
			// ����UserMapper����
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// ������װ�������ò�ѯ����
					UserQueryVo userQueryVo = new UserQueryVo();;
					UserCustom userCustom = new UserCustom();
					userCustom.setSex("1");
//					userCustom.setUsername("������");
					userQueryVo.setUserCustom(userCustom);
					
				// ����userMapper�ķ���
					try {
						List<UserCustom> user = userMapper.findUserList(userQueryVo);
						sqlSession.close();
						System.out.println(user);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
//		@Test
		// �û���Ϣ���ۺϲ�ѯ
		public void findUserCount() throws IOException {
			// mybatis �����ļ�
					String resource = "SqlMapConfig.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					// �����Ự����
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					// ͨ�������õ�SqlSession
					SqlSession sqlSession= sqlSessionFactory.openSession();
			// ����UserMapper����
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// ������װ�������ò�ѯ����
					UserQueryVo userQueryVo = new UserQueryVo();;
					UserCustom userCustom = new UserCustom();
//					userCustom.setSex("1");
//					userCustom.setUsername("������");
					userQueryVo.setUserCustom(userCustom);
					
				// ����userMapper�ķ���
					try {
						int count = userMapper.findUserCount(userQueryVo);
						sqlSession.close();
						System.out.println(count);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
}
