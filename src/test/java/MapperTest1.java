import jarry.atguigu.crud.bean.Department;
import jarry.atguigu.crud.bean.Employee;
import jarry.atguigu.crud.dao.DepartmentMapper;
import jarry.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao 层的工作
 * 推荐Spring 的项目可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1.导入SpringTest 模块
 * 2.@ContextConfiguration 指定Spring配置文件的位置
 * 3.直接autowired 要使用的
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest1 {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试departMentdept
     */
    @Test
    public void testCRUD(){
       // 1.根据配置文件，创建spring ioc  容器
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        // 2.从容器中获取mapper
//        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        // 1.插入几个部门
        departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));
        departmentMapper.insertSelective(new Department(null,"工程部"));
//        employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@guigu.com",1));
        //3 ,批量插入多个员工，批量：使用可以执行批量操作的sqlSession
//        for(int ){
//            employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@guigu.com",1));

//        }
         EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
         for(int i=0;i<10;i++){
             String uuid = UUID.randomUUID().toString().substring(0,5) + i;
             System.out.println(UUID.randomUUID());
             mapper.insertSelective(new Employee(null,uuid,"M",uuid+"@atguigu.com",1));
         };
//        for(int i=0;i<1000;i++){
//            mapper.deleteByPrimaryKey(i);
//        }
        System.out.println("批量插入完成！");



    }

}
