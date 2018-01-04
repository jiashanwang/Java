package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

/**
 * mapper 接口 相当于dao接口，用户管理
 * @author Administrator
 *注意：程序员编写mapper接口需要遵循 一些开发规范，mybatis 可以自动生成mapper 接口实现类代理对象
 *开发规范：
 *1，在mapper.xml中，namesapce等于mapper接口地址
 *2.UserMapper.java接口中的方法名和mapper.xml中statement的id一致
 *3，mapper接口中方法的输入参数类型和UserMapper.xml中statement中的parameterType指定的类型一致
 *4，mapper.java 接口中的方法返回值类型和UserMapper.xml 中statement 的resultType指定的类型 一致；·
 *mapper接口只有遵循了以上的规范，mybatis 才会自动生成mapper接口实现类的代理对象
 *
 *总结：以上开发规范，主要是对
 */


/**
 * mapper代理的开发规范
 * 总结： 	mapper 接口方法参数只能有一个，系统是否不利于扩展维护
		系统框架中，dao层的代码是被业务层公用的
	及时mapper 接口只有一个参数，可以使用包装类型的pojo满足不同的业务方法的需求，
	注意：持久层方法的参数可以是包装类型，可以是map等等，service 方法中建议不要使用包装类型（不利于业务的可扩展性）
-->
 */

public  interface UserMapper {
	// 用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
//	 根据id 查询用户信息
		public User findUserById(int id) throws Exception;
	// 根据用户名列查询用户列表????
		// 代理对象内部调用selectOne 或selectList
		// 如果mapper 方法返回单个pojo对象，（非集合对象，），代理对象内部通过selectOne 查询数据库
		// 如果mapper 方法返回集合对象，代理对象内部通过selectList 查询数据库
		public List<User> findUserByName(String name) throws Exception;
	// 添加用户信息
		public void insertUser(User user) throws Exception;
		//根据id 查询用户信息，使用resultMap 输出
		public User findUserByIdResultMap(int id) throws Exception;
		
	// 删除用户
		public void deleteUser(int id) throws Exception;
	// 用户信息的综合查询总数
		public int findUserCount (UserQueryVo userQueryVo) throws Exception;
		
}
