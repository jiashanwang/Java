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
 * 入门程序
 * @author Administrator
 *
 */
public class MybatisFirst {
	// 根据id 查询用户信息，得到一条记录 的结果
//	public static final void main(String[] args) throws IOException {
//		findUsrByIdTest();
//	}
//	@Test
	public void findUsrByIdTest() throws IOException {
		// mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession= sqlSessionFactory.openSession();
		
		//通过SqlSession 操作数据库
		// 第一个参数：映射文件中statement的id,等于=namespace+ "." + statement的id
		// 第二个参数，指定和映射文件中所匹配 的parameterType 类型的参数
		//sqlSession.selectOne 结果是与映射文件所匹配的resultType类型的对象
		
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		// 释放资源
		try {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 根据用户名称模糊查询用户列表
//	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis 配置文件
				String resource = "SqlMapConfig.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				// 创建会话工厂
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// 通过工厂得到SqlSession
				SqlSession sqlSession= sqlSessionFactory.openSession();
				
				//通过SqlSession 操作数据库
				// 第一个参数：映射文件中statement的id,等于=namespace+ "." + statement的id
				// 第二个参数，指定和映射文件中所匹配 的parameterType 类型的参数
				//sqlSession.selectOne 结果是与映射文件所匹配的resultType类型的对象
				// list 中的userh和映射文件中的resultTye中的类型时相同的
			List<User> list = sqlSession.selectList("test.findUserByName","%小明%");
			
			System.out.println(list);
			
			// 释放资源
			try {
				if(sqlSession!=null) {
					sqlSession.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	// 添加用户信息
	@Test
	public void insertUserTest() throws IOException {
		// mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession= sqlSessionFactory.openSession();
		
		//通过SqlSession 操作数据库
		// 第一个参数：映射文件中statement的id,等于=namespace+ "." + statement的id
		// 第二个参数，指定和映射文件中所匹配 的parameterType 类型的参数
		//sqlSession.selectOne 结果是与映射文件所匹配的resultType类型的对象
		// list 中的userh和映射文件中的resultTye中的类型时相同的
		// 插入用户对象
			User user = new User();
			user.setId(102);
			user.setUsername("王大川1");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setAddress("河南郑州331");
		// list中的user和映射文件中resultType 所指定的类型一直
			sqlSession.insert("test.insertUser", user);
		
			// 提交事务
				sqlSession.commit();
			
			// 释放资源
			try {
				if(sqlSession!=null) {
					sqlSession.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
}
