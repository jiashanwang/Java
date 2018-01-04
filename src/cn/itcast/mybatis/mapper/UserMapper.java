package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

/**
 * mapper �ӿ� �൱��dao�ӿڣ��û�����
 * @author Administrator
 *ע�⣺����Ա��дmapper�ӿ���Ҫ��ѭ һЩ�����淶��mybatis �����Զ�����mapper �ӿ�ʵ����������
 *�����淶��
 *1����mapper.xml�У�namesapce����mapper�ӿڵ�ַ
 *2.UserMapper.java�ӿ��еķ�������mapper.xml��statement��idһ��
 *3��mapper�ӿ��з���������������ͺ�UserMapper.xml��statement�е�parameterTypeָ��������һ��
 *4��mapper.java �ӿ��еķ�������ֵ���ͺ�UserMapper.xml ��statement ��resultTypeָ�������� һ�£���
 *mapper�ӿ�ֻ����ѭ�����ϵĹ淶��mybatis �Ż��Զ�����mapper�ӿ�ʵ����Ĵ������
 *
 *�ܽ᣺���Ͽ����淶����Ҫ�Ƕ�
 */


/**
 * mapper����Ŀ����淶
 * �ܽ᣺ 	mapper �ӿڷ�������ֻ����һ����ϵͳ�Ƿ�������չά��
		ϵͳ����У�dao��Ĵ����Ǳ�ҵ��㹫�õ�
	��ʱmapper �ӿ�ֻ��һ������������ʹ�ð�װ���͵�pojo���㲻ͬ��ҵ�񷽷�������
	ע�⣺�־ò㷽���Ĳ��������ǰ�װ���ͣ�������map�ȵȣ�service �����н��鲻Ҫʹ�ð�װ���ͣ�������ҵ��Ŀ���չ�ԣ�
-->
 */

public  interface UserMapper {
	// �û���Ϣ�ۺϲ�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
//	 ����id ��ѯ�û���Ϣ
		public User findUserById(int id) throws Exception;
	// �����û����в�ѯ�û��б�????
		// ��������ڲ�����selectOne ��selectList
		// ���mapper �������ص���pojo���󣬣��Ǽ��϶��󣬣�����������ڲ�ͨ��selectOne ��ѯ���ݿ�
		// ���mapper �������ؼ��϶��󣬴�������ڲ�ͨ��selectList ��ѯ���ݿ�
		public List<User> findUserByName(String name) throws Exception;
	// ����û���Ϣ
		public void insertUser(User user) throws Exception;
		//����id ��ѯ�û���Ϣ��ʹ��resultMap ���
		public User findUserByIdResultMap(int id) throws Exception;
		
	// ɾ���û�
		public void deleteUser(int id) throws Exception;
	// �û���Ϣ���ۺϲ�ѯ����
		public int findUserCount (UserQueryVo userQueryVo) throws Exception;
		
}
