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
	// 根据id 来查询单个记录 
	public static void test() throws IOException {
		// mybatis 配置文件
				String resource = "SqlMapConfig.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				// 创建会话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// 通过工厂得到SqlSession
				SqlSession sqlSession= sqlSessionFactory.openSession();
		// 创建UserMapper对象，
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用userMapper的方法
				
				try {
					User user = userMapper.findUserById(105);
					sqlSession.close();
					System.out.println(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	// 输出一个resultMap
	// 根据name来查询多个记录
		public static void testListMap() throws IOException {
			// mybatis 配置文件
					String resource = "SqlMapConfig.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					// 创建会话工厂
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					// 通过工厂得到SqlSession
					SqlSession sqlSession= sqlSessionFactory.openSession();
			// 创建UserMapper对象，
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				// 调用userMapper的方法
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
		// 用户信息的综合查询
		public void findList() throws IOException {
			// mybatis 配置文件
					String resource = "SqlMapConfig.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					// 创建会话工厂
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					// 通过工厂得到SqlSession
					SqlSession sqlSession= sqlSessionFactory.openSession();
			// 创建UserMapper对象，
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 创建包装对象，设置查询条件
					UserQueryVo userQueryVo = new UserQueryVo();;
					UserCustom userCustom = new UserCustom();
					userCustom.setSex("1");
//					userCustom.setUsername("张三丰");
					userQueryVo.setUserCustom(userCustom);
					
				// 调用userMapper的方法
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
		// 用户信息的综合查询
		public void findUserCount() throws IOException {
			// mybatis 配置文件
					String resource = "SqlMapConfig.xml";
					InputStream inputStream = Resources.getResourceAsStream(resource);
					// 创建会话工厂
					SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					// 通过工厂得到SqlSession
					SqlSession sqlSession= sqlSessionFactory.openSession();
			// 创建UserMapper对象，
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 创建包装对象，设置查询条件
					UserQueryVo userQueryVo = new UserQueryVo();;
					UserCustom userCustom = new UserCustom();
//					userCustom.setSex("1");
//					userCustom.setUsername("张三丰");
					userQueryVo.setUserCustom(userCustom);
					
				// 调用userMapper的方法
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
